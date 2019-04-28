package com.springimplant.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springimplant.mvc.data.entities.Project;
import com.springimplant.mvc.data.services.ProjectService;

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
	
	@RequestMapping(value="/find")
	public String find(Model model)
	{
		model.addAttribute("projects",this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProject(HttpSession session)
	{
		session.setAttribute("token","12345");
		System.out.println("Invoking addProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveProject(@ModelAttribute Project project,HttpServletRequest request,@RequestParam("name") String name,HttpSession session)
	{
		System.out.println(session.getAttribute("token"));
		System.out.println(request.getParameter("name"));
		System.out.println(name);
		System.out.println(project);
		System.out.println("Invoking saveProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,params={"type=multi"})
	public String saveMulti()
	{
		System.out.println("Invoking saveMulti");
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,params={"type=multi","special"})
	public String saveSpecial()
	{
		System.out.println("Invoking saveSpecial");
		return "project_add";
	}
	
}