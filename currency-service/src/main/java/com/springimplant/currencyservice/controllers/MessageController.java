package com.springimplant.currencyservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.currencyservice.contract.DeliveryPartnerData;
import com.springimplant.currencyservice.contract.User;
import com.springimplant.currencyservice.producer.DeliveryPartnerPhone;
import com.springimplant.currencyservice.producer.KafkaJsonProducer;
import com.springimplant.currencyservice.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafkaProducer;
    private KafkaJsonProducer kafkaJsonProducer;
    private DeliveryPartnerPhone deliveryPartnerPhone;

    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer,DeliveryPartnerPhone phone) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
        this.deliveryPartnerPhone = phone;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message published to the topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJson(@RequestBody User user) {
        kafkaJsonProducer.publishMessage(user);
        return ResponseEntity.ok("JSON Message published successfully!");
    }
    
    @GetMapping("/publishpartner")
    public ResponseEntity<String> publishPartner() {
    	DeliveryPartnerData dp1 = DeliveryPartnerData.builder()
    			.orderId(1)
    			.firstName("Lampard")
    			.lastName("Messi")
    			.distance(1500)
    			.estimatedTime(5)
    			.xCoordinte(Math.random()*(50-10)+10)
    			.yCoordinte(Math.random()*(50-10)+10)
    			.build();
    	try {
			deliveryPartnerPhone.publishDeliveryPartnerData(dp1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
        return ResponseEntity.ok("Message published to the topic");
    }
}
