package com.springimplant.mvc.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public String gohome()
	{
		return "home";
	}
	
	@RequestMapping("/index")
	public String goindex()
	{
		return "index";
	}
	
	@RequestMapping("/help")
	public ModelAndView gohelp()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name","Samuel");
		modelAndView.addObject("rollnumber",12);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time",now);
		modelAndView.setViewName("help");
		return modelAndView;
	}
}
