package com.springimplant.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springimplant.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("resource",new Resource());
		return "resource_add";
	}
	
	@RequestMapping("/save")
	public String save()
	{
		System.out.println("Invoking save() method");
		return "resource_add";
	}
}
