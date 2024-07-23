package com.springmvc.bms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	   @GetMapping(value="hello")
	    public String sayHello(ModelMap model) {
	        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
	        return "welcome";
	    }
	 
	    @GetMapping(value="helloagain")
	    public String sayHelloAgain(ModelMap model) {
	        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
	        return "welcome";
	    }
}
