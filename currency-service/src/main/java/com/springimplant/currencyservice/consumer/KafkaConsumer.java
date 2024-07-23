package com.springimplant.currencyservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springimplant.currencyservice.contract.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	
	@KafkaListener(topics="springimplantTopic",groupId = "myGroup")
	public void listenMyTopic(String message) {
	    log.info("Received String Message in group myGroup: " + message);
	}
	
	@KafkaListener(topics="springimplantJsonTopic",groupId = "myGroup")
	public void listenMyJsonTopic(User user) {
	    log.info("Received Json Message in group myGroup: " + user);
	}
}
