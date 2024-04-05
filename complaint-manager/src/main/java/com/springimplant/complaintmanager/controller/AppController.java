package com.springimplant.complaintmanager.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController
{
	@Autowired
	SessionFactory sessionFactory;
	
    @GetMapping("/helloworld")
    public String helloWorld()
    {
    	return "HelloWorld";
    }
}