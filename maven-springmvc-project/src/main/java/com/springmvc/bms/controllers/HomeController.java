package com.springmvc.bms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
