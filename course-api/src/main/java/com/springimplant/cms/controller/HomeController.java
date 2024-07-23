package com.springimplant.cms.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
}
