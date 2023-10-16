package com.springmvcimplant.ioc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("Going to Home");
		return "home";
	}
}
