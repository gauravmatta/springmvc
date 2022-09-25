package com.springimplant.jwt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String Welcome() {
		return "Welcome to Spring Implant";
	}
}
