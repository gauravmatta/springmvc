package com.springimplant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.dto.EmployeeDto;
import com.springimplant.entity.Employee;
import com.springimplant.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto emp){
		log.info(emp.toString());
		service.addEmployee(emp);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("empid") Integer empidL){
		Employee empRetrived = service.getEmpById(empidL);
		return new ResponseEntity<>(empRetrived,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Integer empidL){
		service.deleteEmpById(empidL);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
