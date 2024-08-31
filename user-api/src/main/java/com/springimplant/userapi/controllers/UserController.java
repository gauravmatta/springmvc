package com.springimplant.userapi.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springimplant.userapi.sqllite.entity.User;
import com.springimplant.userapi.sqllite.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/auth")
	public String getmsg() {
		String url= "http://authorization-api/";
		return restTemplate.getForObject(url,String.class);
	}
	
	@GetMapping("/")
	public List<User> getUser()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public List<User> getUsersForACourse(@PathVariable BigInteger id)
	{
		return userRepository.findByuserid(id);
	}
	
	@GetMapping("course/{id}")
	public List<User> getCourseForAUser(@PathVariable BigInteger id)
	{
		return userRepository.findBycourseid(id);
	}
	
	@GetMapping("/staticusers")
	public List<User> getUsers() {
		return Stream.of(new User(33,44,"Gaurav"),
						new User(55,22,"Mohit"),
						new User(67,43,"Rohit")).collect(Collectors.toList());
	}
	
}
