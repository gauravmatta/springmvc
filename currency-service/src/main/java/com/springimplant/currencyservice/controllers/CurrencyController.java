package com.springimplant.currencyservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
	
	@Value(("${server.port}"))
	private String port;

	@GetMapping("/")
	public String returnPort()
	{
		return "You are redirected to port "+port;
	}
}
