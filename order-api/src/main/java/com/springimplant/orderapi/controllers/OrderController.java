package com.springimplant.orderapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.basedomains.dto.Order;
import com.springimplant.basedomains.dto.OrderEvent;
import com.springimplant.orderapi.kafka.OrderProducer;
import com.springimplant.orderapi.service.OrderService;


@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	private OrderProducer orderProducer;
	private OrderService orderService;
	
	public OrderController(OrderProducer orderProducer,OrderService orderService) {
		super();
		this.orderProducer = orderProducer;
		this.orderService = orderService;
	}
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderEvent event = new OrderEvent();
		event.setStatus("PENDING");
		event.setMessage("order status is in pending state");
		event.setOrder(order);
		orderProducer.sendMessage(event);
		return "Order Placed Successfully";
	}
	
	@PostMapping("/order/create")
	public ResponseEntity<com.springimplant.orderapi.entites.Order> createOrder(@RequestBody com.springimplant.orderapi.entites.Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order));
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<com.springimplant.orderapi.entites.Order> getOrder(@PathVariable Long orderId){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.get(orderId));
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<com.springimplant.orderapi.entites.Order>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
	}
	
}
