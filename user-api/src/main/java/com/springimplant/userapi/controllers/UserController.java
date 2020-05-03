package com.springimplant.userapi.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.userapi.entity.User;
import com.springimplant.userapi.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<User> getUser()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public List<User> getUsersForACourse(@PathVariable("id") BigInteger id)
	{
		return userRepository.findByuserid(id);
	}
	
	@GetMapping("course/{id}")
	public List<User> getCourseForAUser(@PathVariable("id") BigInteger id)
	{
		return userRepository.findBycourseid(id);
	}
	
}
