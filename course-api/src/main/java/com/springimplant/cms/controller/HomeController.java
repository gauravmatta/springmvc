package com.springimplant.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/login")
	public String loginPage()
	{
		return "login.jsp";
	}
	
	@GetMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}
}
