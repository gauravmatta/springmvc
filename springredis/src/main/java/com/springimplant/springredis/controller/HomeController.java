package com.springimplant.springredis.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

@RestController
public class HomeController {
	
	private final String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home(Principal principal, HttpSession session) {
		incrementCount(session,HOME_VIEW_COUNT);
		LOGGER.info("Hello " + principal.getName());
		return "Hello " + principal.getName();
	}
	
	@GetMapping("/count")
	public String count(HttpSession session){
		return "HOME_VIEW_COUNT: "+ session.getAttribute(HOME_VIEW_COUNT);
	}

	private void incrementCount(HttpSession session, String attr) {
		var homeViewCount =	session.getAttribute(attr) == null ? 0: (Integer) session.getAttribute(attr);
		session.setAttribute(attr,homeViewCount+=1);
	}
}
