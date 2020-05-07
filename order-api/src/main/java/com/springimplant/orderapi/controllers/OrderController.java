package com.springimplant.orderapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Value(("${organization.name}"))
	private String organizationName;
	@Value(("${service.welcome.message}"))
	private String serviceMessage;

	@GetMapping("/")
	public String getOrder()
	{
		return(organizationName+"***"+serviceMessage);
	}
}
