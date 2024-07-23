package com.springimplant.currencyservice.producer;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springimplant.currencyservice.contract.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaJsonProducer {
	
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void publishMessage(User user) {
		Message<User> messge = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC,"springimplantJsonTopic")
				.build();
		kafkaTemplate.send(messge);
		log.info("Message Published {}",user);
	}
	
	

}
