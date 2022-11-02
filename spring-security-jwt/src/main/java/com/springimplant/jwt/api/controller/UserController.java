package com.springimplant.jwt.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.repository.UserRepository;
import com.springimplant.jwt.api.service.CustomUserDetailService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	
	@GetMapping
	@RolesAllowed({"Scorecard"})
	//In case you don't want to override GrantedAuthorityDefaults in Security Config feel free to use this as an alternative.
	@PreAuthorize("hasAuthority('Search')")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User findBysso(@PathVariable("id") String id){
		Optional<User> userObjOptional = userRepository.findByUserId(id);
		return userObjOptional.orElse(null);
	}
	
	@GetMapping("/getuserdetails/{id}")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable("id") String sso) {
		UserDetails userDetails = customUserDetailService.loadUserByUsername(sso);
		return ResponseEntity.status(HttpStatus.OK).body(userDetails);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		User savedUser = userRepository.save(user);
		URI userUri = URI.create("/users/" + savedUser.getId());
		return ResponseEntity.created(userUri).body(savedUser);
	}
	
}
