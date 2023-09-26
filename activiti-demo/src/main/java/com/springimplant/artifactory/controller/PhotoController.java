package com.springimplant.artifactory.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.activiti.engine.task.Task;
import com.springimplant.artifactory.entity.Photo;
import com.springimplant.artifactory.repository.PhotoRepository;
import com.springimplant.artifactory.service.PhotoService;

@Controller
class PhotoMvcController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private TaskService taskService;


    @PostMapping(value = "/upload")
    String upload(MultipartHttpServletRequest request, Principal principal) {

        System.out.println("uploading for " + principal.toString());
        Optional.ofNullable(request.getMultiFileMap()).ifPresent(m -> {

            // gather all the MFs in one collection
            List<MultipartFile> multipartFiles = new ArrayList<>();
            m.values().forEach((t) -> {
                multipartFiles.addAll(t);
            });

            // convert them all into `Photo`s
            List<Photo> photos = multipartFiles.stream().map(f -> {
                try {
                    return this.photoService.createPhoto(principal.getName(), f.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

            System.out.println("started photo process w/ process instance ID: " +
                    this.photoService.launchPhotoProcess(photos).getId());

        });
        return "redirect:/";
    }

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    Resource image(@PathVariable Long id) {
        return new InputStreamResource(this.photoService.readPhoto(this.photoRepository.findById(id).get()));
    }

    @PostMapping(value = "/approve")
    String approveTask(@RequestParam String taskId, @RequestParam String approved) {
        boolean isApproved = !(approved == null || approved.trim().equals("") || approved.toLowerCase().contains("f") || approved.contains("0"));
        this.taskService.complete(taskId, Collections.singletonMap("approved", isApproved));
        return "redirect:approve";
    }

    @GetMapping(value = "/approve")
    String setupApprovalPage(Model model) {
        List<Task> outstandingTasks = taskService.createTaskQuery()
                .taskCandidateGroup("photoReviewers")
                .list();
        if (0 < outstandingTasks.size()) {
            Task task = outstandingTasks.iterator().next();
            model.addAttribute("task", task);
            List<Photo> photos = (List<Photo>) taskService.getVariable(task.getId(), "photos");
            model.addAttribute("photos", photos);
        }
        return "approve";
    }
}
