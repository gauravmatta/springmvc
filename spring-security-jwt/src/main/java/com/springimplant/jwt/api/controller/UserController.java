package com.springimplant.jwt.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	@RolesAllowed({"Scorecard"})
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User findBysso(@PathVariable("id") String id){
		Optional<User> userObjOptional = userRepository.findByUserId(id);
		return userObjOptional.orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		User savedUser = userRepository.save(user);
		URI userUri = URI.create("/users/" + savedUser.getId());
		return ResponseEntity.created(userUri).body(savedUser);
	}
	
}
