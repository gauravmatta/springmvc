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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.dto.UserDto;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.repository.UserRepository;
import com.springimplant.jwt.api.service.CustomUserDetailService;
import com.springimplant.jwt.api.service.impl.CustomUserDetailServiceImpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private UserDetailsService userDetailService;

	@GetMapping("/roles")
	public ResponseEntity<List<UserDto>> getUsersByRoles(@RequestParam("role") String role) {
		log.info("Roles recieved is :" + role);
		List<UserDto> users = customUserDetailService.getUsersByRole(role);
		List<UserDto> usersw = customUserDetailService.getUsersByRole();
		log.info("Controller Users are :" + usersw);
		return ResponseEntity.ok().body(users);
	}
	
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
		UserDetails userDetails = userDetailService.loadUserByUsername(sso);
		return ResponseEntity.status(HttpStatus.OK).body(userDetails);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		User savedUser = userRepository.save(user);
		URI userUri = URI.create("/users/" + savedUser.getId());
		return ResponseEntity.created(userUri).body(savedUser);
	}
	
}
