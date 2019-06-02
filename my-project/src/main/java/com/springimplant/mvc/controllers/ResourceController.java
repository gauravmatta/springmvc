package com.springimplant.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springimplant.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource)
	{
		System.out.println("Invoking Review() method");
		return "resource_review";
	}
	
	@RequestMapping("/add")
	public String add(Model model)
	{
		System.out.println("Invoking add() method");
		return "resource_add";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource,Model model) throws ClassNotFoundException
	{
		System.out.println("Invoking save() method");
		System.out.println(resource);
		return "redirect:/resource/add";
	}
	
	@ModelAttribute("resource")
	public Resource getResource()
	{
		System.out.println("Adding a new Resource to the model");
		return new Resource();
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks()
	{
		System.out.println("Adding CheckOptions");
		return new LinkedList<>(Arrays.asList(new String[]{"Lead Time","Special Rate","Requires Approval"}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios()
	{
		return new LinkedList<>(Arrays.asList(new String[]{"Hours","Piece","Tons"}));
	}
	
	@ModelAttribute("itemOptions")
	public List<String> getItems()
	{
		return new LinkedList<>(Arrays.asList(new String[]{"Lead Time","Special Rate","Requires Approval"}));
	}
}
