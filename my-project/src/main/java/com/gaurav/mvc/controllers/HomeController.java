package com.gaurav.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springimplant.mvc.data.entities.Project;

@Controller
public class HomeController {
	
//	private ExampleService service;

	@RequestMapping("/")
	public String goHome(Model model)
	{
		Project project=new Project();
		project.setName("Java Tutorial");
		project.setSponser("Spring Implant");
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
	
	@RequestMapping("/test/{testId}")
	public String test(@PathVariable("testId") Long testId,Model model)
	{
		model.addAttribute("msg",testId);
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
		
		return "home";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Example example,Model model)
	{
		model.addAttribute("msg",example.getName());
		return "home";
	}
}
