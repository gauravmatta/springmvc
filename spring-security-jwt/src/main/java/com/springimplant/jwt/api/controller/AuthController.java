package com.springimplant.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.jwt.api.type.AuthRequest;
import com.springimplant.jwt.api.util.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String Welcome() {
		return "Welcome to Spring Implant";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
					);
		} catch (Exception e) {
			throw new Exception("Invalid Username/Password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
