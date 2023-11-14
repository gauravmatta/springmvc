package com.springimplant.complaintmanager.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springimplant.complaintmanager.config.Utils;
import com.springimplant.complaintmanager.dao.ComplaintDao;
import com.springimplant.complaintmanager.entities.Complaint;

@RestController
@PropertySource({"classpath:admin-properties.properties"})
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