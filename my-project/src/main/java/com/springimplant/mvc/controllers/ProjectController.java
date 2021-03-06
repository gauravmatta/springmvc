package com.springimplant.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springimplant.mvc.data.entities.Project;
import com.springimplant.mvc.data.services.ProjectService;
import com.springimplant.mvc.data.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/{projectId}")
	public String findProject(Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project",this.projectService.find(projectId));
		return "project";
	}
	
	@RequestMapping(value="/find/{projectId}")
	@ResponseBody
	public Project findProjectObject(Model model, @PathVariable("projectId") Long projectId)
	{
		Project p1=this.projectService.find(projectId);		
		return p1;
	}
	
	@RequestMapping(value="/find")
	public String find(Model model)
	{
		model.addAttribute("projects",this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/exception")
	public String exception()
	{
		if(1==1)
		{
			throw new RuntimeException("There was an Error");
		}
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProject(HttpSession session,Model model)
	{
		session.setAttribute("token","12345");
		System.out.println("Invoking addProject");
		model.addAttribute("types",new ArrayList<String>(){{
			add("");
			add("Single Year");
			add("Multi Year");
		}});
		model.addAttribute("project",new Project());
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project,Errors errors,HttpServletRequest request,@RequestParam("name") String name,HttpSession session,Model model,RedirectAttributes attributes)
	{
		if(errors.hasErrors())
		{
			System.out.println("The Project is not Validated");
			return "project_add";
		}
		else
		{
			System.out.println("The Project is Validated");
		}
		
		System.out.println(session.getAttribute("token"));
		System.out.println(request.getParameter("name"));
		System.out.println(name);
		System.out.println(project);
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addAttribute("projectId", project.getProjectId().toString());
		model.addAttribute("project",project);
		System.out.println("Invoking saveProject");
		return "redirect:/project/find";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,params={"type=Multi Year"})
	public String saveMulti(@Valid @ModelAttribute Project project,Errors errors,@RequestParam("name") String name,HttpSession session,HttpServletRequest request,RedirectAttributes attributes)
	{
		System.out.println("Invoking saveMulti");
		if(errors.hasErrors())
		{
			System.out.println("The Project is not Validated");
			return "project_add";
		}
		else
		{
			System.out.println("The Project is Validated");
		}
		System.out.println(session.getAttribute("token"));
		System.out.println(request.getParameter("name"));
		System.out.println(name);
		System.out.println(project);
		project.setProjectId(66L);
		this.projectService.save(project);
		attributes.addFlashAttribute("project",project);
		return "redirect:/showproject";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,params={"type=multi","special"})
	public String saveSpecial()
	{
		System.out.println("Invoking saveSpecial");
		return "project_add";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new ProjectValidator());
	}
}