package com.springimplant.orderapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.orderapi.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
	
	@Autowired
	EmailService invokeEmail;
	
	@GetMapping("/invoke")
	public String invokeEmail() {
		return invokeEmail.invokeChat();
	}

}
