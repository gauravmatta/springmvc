package com.springimplant.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProject()
	{
		System.out.println("Invoking addProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveProject()
	{
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