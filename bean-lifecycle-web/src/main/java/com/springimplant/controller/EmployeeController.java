package com.springimplant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.dto.EmployeeDto;
import com.springimplant.entity.Employee;
import com.springimplant.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> getEmpById(@RequestBody EmployeeDto emp){
		service.addEmployee(emp);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
