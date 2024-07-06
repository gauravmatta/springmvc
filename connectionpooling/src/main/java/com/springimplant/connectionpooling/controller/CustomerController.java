package com.springimplant.connectionpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.connectionpooling.entity.Customers;
import com.springimplant.connectionpooling.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@GetMapping("/getcustomers")
	public ResponseEntity<List<Customers>> getcustomer(){
		List<Customers> customers =	cService.processCustomers();
		return ResponseEntity
		        .status(HttpStatus.OK)
		        .header("Custom-Header", "Custom-Value")
		        .body(customers);
	}

}
