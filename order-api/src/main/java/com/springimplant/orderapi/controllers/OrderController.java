package com.springimplant.orderapi.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.basedomains.dto.Order;
import com.springimplant.basedomains.dto.OrderEvent;
import com.springimplant.orderapi.kafka.OrderProducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RefreshScope
@RequestMapping("/api/v1")
public class OrderController {
	
	@Value(("${organization.name}"))
	private String organizationName;
	@Value(("${service.welcome.message}"))
	private String serviceMessage;
	
	private OrderProducer orderProducer;
	
	public OrderController(String organizationName, String serviceMessage, OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
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

	@GetMapping("/")
	public String getOrder()
	{
		return(organizationName+"***"+serviceMessage);
	}
	
	
	
}
