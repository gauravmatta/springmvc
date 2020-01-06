package com.springimplant.mvc.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springimplant.mvc.data.entities.Project;
import com.springimplant.mvc.data.services.ProjectService;

@Controller
public class HomeController {
	
	@Autowired
	private ProjectService service;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(Model model)
	{
		return "Welcome Home";
	}
	
	@RequestMapping(value="/", params="projectId")
	public String goProjectHome(Model model,@RequestParam("projectId") Long projectId)
	{
		model.addAttribute("currentProject",this.service.find(projectId));
		return "home";
	}
	
	@RequestMapping("/xml")
	public String goXml(Model model)
	{
		Project project=new Project();
		project.setName("Java Tutorial");
		project.setSponsor(null);
		project.setDescription("A simple project initiated to Learn Java with Fun");
		model.addAttribute("currentProject",project);
		return "xmlwelcome";
	}
	
	@RequestMapping("/welcome")
	public String goNoxml(Model model)
	{
		Project project=new Project();
		project.setName("Java Tutorial");
		project.setSponsor(null);
		project.setDescription("A simple project initiated to Learn Java with Fun");
		model.addAttribute("currentProject",project);
		return "welcome";
	}
	
	@RequestMapping("/test/{testId}")
	public String test(@PathVariable("testId") Long testId,Model model)
	{
		model.addAttribute("msg",testId);
		return "home";
	}
	
	@RequestMapping("/home")
	public String goHome(Model model)
	{
		Project project=new Project();
		project.setName("Java Tutorial");
		project.setSponsor(null);
		project.setDescription("A simple project initiated to Learn Java with Fun");
		model.addAttribute("currentProject",project);
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("msg","Spring Mvc");
		return "home";
	}
	
	@RequestMapping("/example")
	public String test(@RequestParam("action") String action,Model model)
	{
		model.addAttribute("msg",action);
		return "home";
	}
		
	@RequestMapping("/example2")
	public String test2(HttpServletRequest request,HttpSession session)
	{
		System.out.println("Request Object :");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) 
		{
			String headerName = (String)headerNames.nextElement(); 
			System.out.print(headerName+"-->"); 
			System.out.println(request.getHeader(headerName)); 
		}
		System.out.println("Session Object :");
		System.out.println(session);
		return "home";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Example example,Model model)
	{
		example.setName("Spring Implant");
		model.addAttribute("msg",example.getName());
		return "home";
	}

}
