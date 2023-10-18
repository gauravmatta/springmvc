package com.springmvcimplant.ioc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springmvcimplant.ioc.entities.Student;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@RequestMapping("/lookup")
	public RedirectView search(@RequestParam("querybox") String query) {
		String url = "https://www.google.co.in?q="+query;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("Going to Home");
		return "home";
	}
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("Going to Form");
		return "form";
	}
	
	@RequestMapping(path="/handle",method = RequestMethod.POST)
	public String handle(@ModelAttribute("student") Student student) {
		System.out.println("Going to Handle");
		System.out.println(student.toString());
		return "success";
	}
}
