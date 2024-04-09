package com.springimplant.complaintmanager.controller;

import java.security.Principal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppController
{
	@Autowired
	SessionFactory sessionFactory;
	
    @GetMapping("/helloworld")
    public String helloWorld()
    {
    	log.info("Hello World ");
    	return "HelloWorld";
    }
    
    @GetMapping("/")
    public String home(Principal principal)
    {
    	log.info("Root ");
    	return "Hello, "+ principal.getName();
    }
}