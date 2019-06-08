package com.springimplant.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public ModelAndView welcome()
	{
		return new ModelAndView("welcome");
	}
}