package com.springimplant.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springimplant.mvc.data.entities.Resource;
import com.springimplant.mvc.data.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;

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
	
	@RequestMapping("/{resourceId}")
	public String findResource(Model model, @PathVariable("resourceId") Long projectId) {
		model.addAttribute("resource",this.resourceService.find(projectId));
		return "resource";
	}
	
	@RequestMapping("/find/{resourceId}")
	@ResponseBody
	public Resource findResourceObject(@PathVariable("resourceId") Resource resource){
//		return resourceService.find(resourceId);
		return resource;
	}
	
	@RequestMapping("/exception")
	public String exception(Model model)
	{
		if(1==1)
		{
			throw new RuntimeException("There was an error");
		}
		return "resource_add";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource,SessionStatus status) throws ClassNotFoundException
	{
		System.out.println("Invoking save() method");
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping("/find")
	public String find(Model model){
		model.addAttribute("resources", resourceService.findAll());
		return "resources";
	}
	
	@RequestMapping(value="/request",method=RequestMethod.POST)
	@ResponseBody
	public String request(@RequestBody String resource)
	{
		//Send an Email for Request
		//Format this into an json array to be handled in js
		System.out.println(resource);
		return "The request has been sent for Approval";
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
