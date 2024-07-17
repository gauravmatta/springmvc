package com.springimplant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.entity.Employee;
import com.springimplant.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/add")
	public ResponseEntity<?> getEmpById(@RequestBody Employee emp){
		service.addEmployee(emp);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}
}
