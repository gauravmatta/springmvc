package com.springimplant.deadletter.queue.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springimplant.deadletter.queue.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonProducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.json.routing_key.name}")
	private String routing_json_key;
	
	private RabbitTemplate rabbitTemplate;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendJsonMessage(User user) {
		log.info(String.format("Json message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange,routing_json_key,user);
	}
}
