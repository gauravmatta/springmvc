package com.springimplant.votingsystem.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.votingsystem.entity.Employee;
import com.springimplant.votingsystem.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger LOGGER  = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(@RequestHeader("correlationId") String correlationId){
		LOGGER.info("Inside getAllEmployee method of Employee Controller");
		return service.getAllEmployee();
	}
	
}
