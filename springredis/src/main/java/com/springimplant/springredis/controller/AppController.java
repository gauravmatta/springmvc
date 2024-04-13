package com.springimplant.springredis.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app")
public class AppController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private WebClient webClient;
	
    @GetMapping("/helloworld")
    public String helloWorld()
    {
    	LOGGER.info("Hello World ");
    	return "HelloWorld";
    }
    
    @GetMapping("/")
    public String home(Principal principal)
    {
    	LOGGER.info("Root ");
    	return "Hello, "+ principal.getName();
    }
    
    @GetMapping("/webclient")
    public Mono<String> webClient(@RequestParam String name) {
    	LOGGER.info("Webclient End Point Called");
    	return webClient.get().uri("google.co.in")
    			.retrieve().toEntity(String.class)
    			.doOnNext(entity -> LOGGER.info("Response status: {}",entity))
    			.mapNotNull(HttpEntity::getBody);
    }
}