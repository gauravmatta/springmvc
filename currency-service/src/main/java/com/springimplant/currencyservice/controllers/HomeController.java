package com.springimplant.currencyservice.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.currencyservice.service.HealthService;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
	
	@Autowired
	@Qualifier("kafkaservice")
	HealthService kafkaService;

	@GetMapping("/get-data")
	public Map<String,String> getData(){
		return Map.of("Name","Gaurav");
	}
	
	@GetMapping("/get-kafka-health")
	public String getMethodName() {
		return kafkaService.health().toString();
	}
	
}
