package com.springimplant.complaintsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}

}