package com.springimplant.artifactory.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.springimplant.artifactory.entity.Photo;
import com.springimplant.artifactory.repository.PhotoRepository;

@Service
@Transactional
public class PhotoService {

    @Autowired
    private TaskService taskService;

    @Value("file://#{ systemProperties['user.home'] }/Desktop/uploads")
    private Resource uploadDirectory;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private PhotoRepository photoRepository;

    @PostConstruct
    public void beforeService() throws Exception {
        File uploadDir = this.uploadDirectory.getFile();
        Assert.isTrue(uploadDir.exists() || uploadDir.mkdirs(), "the " + uploadDir.getAbsolutePath() + " folder must exist!");
    }

    protected void writePhoto(Photo photo, InputStream inputStream) {
        try {
            try (InputStream input = inputStream;
                 FileOutputStream output = new FileOutputStream(new File(this.uploadDirectory.getFile(), Long.toString(photo.getId())))) {
                IOUtils.copy(input, output);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream readPhoto(Photo photo) {
        try {
            return new FileInputStream(new File(this.uploadDirectory.getFile(), Long.toString(photo.getId())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Photo createPhoto(String userId, InputStream bytesForImage) {
        Photo photo = this.photoRepository.save(new Photo((userId), false));
        writePhoto(photo, bytesForImage);
        return photo;
    }

    public ProcessInstance launchPhotoProcess(List<Photo> photos) {
        return runtimeService.startProcessInstanceByKey("photoProcess", Collections.singletonMap("photos", photos));
    }
}