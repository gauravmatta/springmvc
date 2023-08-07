package com.springimplant.activitiproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.activitiproject.dtos.User;

@RestController
public class UserController {

	@RequestMapping("/")
	public String user() {
		return "Hello I am User";
	}
	
	@RequestMapping("/user")
	public User userObject() {
		return User.builder()
				.name("Spring Implant")
				.age(4)
				.build();
	}
}
