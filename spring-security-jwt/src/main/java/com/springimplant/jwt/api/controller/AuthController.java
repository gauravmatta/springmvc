package com.springimplant.jwt.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.service.impl.CustomUserDetailServiceImpl;
import com.springimplant.jwt.api.type.AuthRequest;
import com.springimplant.jwt.api.type.AuthResponse;
import com.springimplant.jwt.api.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailServiceImpl customUserDetailService;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Implant";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody @Valid AuthRequest authRequest) throws AuthenticationException {
		try {
		Authentication authentication =	authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
					);
		User user = (User) authentication.getPrincipal();
		String accessTokenString = jwtUtil.generateToken(user.getUsername());
		AuthResponse response = new AuthResponse(user.getUsername(),accessTokenString);
		return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
//	@PostMapping("/userdetails/{id}")
//	public ResponseEntity<UserDetails> getUserDetails(@PathVariable("id") String id) {
		
//		String authrizationHeaderString = request.getHeader("Authorization");
//		log.info("Authorization header: "+ authrizationHeaderString);
		
//		if(jwtFilter.h
		
//		if(hasAuthorizationHeader(request)) {
//			token=getAccessToken(request);
//			setAuthenticationContext(token,request);	
//		}
		
//		UserDetails userDetails = customUserDetailService.loadUserByUsername(sso);
//		return ResponseEntity.status(HttpStatus.OK).body(userDetails);
//	}
	
	
}
