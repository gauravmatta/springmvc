package com.springmvc.bms.controllers;

import java.util.ArrayList;
import java.util.List;

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
		model.addAttribute("id",37);
		List<String> friends = new ArrayList<>();
		friends.add("Sumit");
		friends.add("Arpit");
		friends.add("Akshay");
		model.addAttribute("friends", friends);
		return "home";
	}
	
	@RequestMapping("/index")
	public String goindex()
	{
		return "index";
	}
}
