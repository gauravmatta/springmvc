package com.springmvc.bms.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView goindex()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name","Samuel");
		modelAndView.addObject("rollnumber",12);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time",now);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
