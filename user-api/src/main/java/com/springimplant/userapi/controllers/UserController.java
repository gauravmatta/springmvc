package com.springimplant.userapi.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springimplant.userapi.service.PostgresUserService;
import com.springimplant.userapi.sqllite.entity.User;
import com.springimplant.userapi.sqllite.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PostgresUserService userService;
	
	
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
						new User(67,43,"Rohit")).toList();
	}
	
	@PostMapping("/users")
	public ResponseEntity<com.springimplant.userapi.postgres.entity.User> createUser(@RequestBody com.springimplant.userapi.postgres.entity.User user){
		com.springimplant.userapi.postgres.entity.User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<com.springimplant.userapi.postgres.entity.User> getSingleUser(@PathVariable String userId){
		com.springimplant.userapi.postgres.entity.User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<com.springimplant.userapi.postgres.entity.User>> getAllUser(){
		List<com.springimplant.userapi.postgres.entity.User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	
}
