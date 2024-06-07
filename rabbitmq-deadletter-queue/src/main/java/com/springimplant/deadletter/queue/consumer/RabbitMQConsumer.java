package com.springimplant.deadletter.queue.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {

	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message) {
		log.info(String.format("Recieved Message -> %s", message));
	}
}
