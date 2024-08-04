package com.springimplant.userapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.userapi.dao.OrderDao;
import com.springimplant.userapi.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/get")
	public ResponseEntity<List<OrderDao>> getOrders() {
		List<OrderDao> orders = orderService.getOrders();
		return ResponseEntity.ok().body(orders);
	}
	

}
