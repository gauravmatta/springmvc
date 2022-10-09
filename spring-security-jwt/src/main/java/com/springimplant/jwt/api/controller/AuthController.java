package com.springimplant.jwt.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.type.AuthRequest;
import com.springimplant.jwt.api.type.AuthResponse;
import com.springimplant.jwt.api.util.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Implant";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody @Valid AuthRequest authRequest) throws Exception {
		try {
		Authentication authentication =	authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
					);
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		String accessTokenString = jwtUtil.generateToken(user.getUsername());
		AuthResponse response = new AuthResponse(user.getUsername(),accessTokenString);
		return ResponseEntity.ok(response);
		
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
