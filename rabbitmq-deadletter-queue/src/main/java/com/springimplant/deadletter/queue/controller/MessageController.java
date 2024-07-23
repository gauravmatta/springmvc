package com.springimplant.deadletter.queue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.deadletter.queue.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	private RabbitMQProducer producer;

	public MessageController(RabbitMQProducer producer) {
		super();
		this.producer = producer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message ){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message Sent To Rabbit MQ....");
	}
}
