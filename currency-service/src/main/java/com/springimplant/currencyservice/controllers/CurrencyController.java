package com.springimplant.currencyservice.controllers;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
	
	@Value(("${server.port}"))
	private String port;

	@GetMapping("/redirect")
	public String returnPort()
	{
		return "You are redirected to port "+port;
	}
	
	@GetMapping("/user")
	public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}
	
	@GetMapping("/error")
	public String error(HttpServletRequest request) {
		String message = (String)request.getSession().getAttribute("error.message");
		request.getSession().removeAttribute("error.message");
		return message; 
	}
}
