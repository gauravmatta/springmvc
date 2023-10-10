package com.springmvc.bms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public String gohome(Model model)
	{
		model.addAttribute("name","Gaurav Matta");
		return "home";
	}
	
	@RequestMapping("/index")
	public String goindex()
	{
		return "index";
	}
}
