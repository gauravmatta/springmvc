package com.springimplant.deadletter.queue.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springimplant.deadletter.queue.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonConsumer {
	
	@RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
	public void ConsumeJsonMessage(User user) {
		 log.info(String.format("Recieved Json Message -> %s", user.toString()));
	 }
}
