package com.springimplant.userapi.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.userapi.dao.OrderDao;
import com.springimplant.userapi.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	public static final String COURSE_SRVICE="courseService";
	
	@GetMapping("/get")
	@CircuitBreaker(name = COURSE_SRVICE,fallbackMethod = "getAllAvilableOrders")
	public ResponseEntity<List<OrderDao>> getOrders() {
		List<OrderDao> orders = orderService.getOrders();
		return ResponseEntity.ok().body(orders);
	}
	
	public ResponseEntity<List<OrderDao>> getAllAvilableOrders(Exception e){
		List<OrderDao> orders = Stream.of(
				new OrderDao("Sample 1","JEE","30 Months",25000),
				new OrderDao("Sample 2","Java","10 Months",15000),
				new OrderDao("Sample 3","Java","10 Months",30000),
				new OrderDao("Sample 4","Mains","2 Years",50000),
				new OrderDao("Sample 5","C","5 Months",10000)
				).collect(Collectors.toList());
		return new ResponseEntity<>(orders, HttpStatus.FAILED_DEPENDENCY);
	}

}
