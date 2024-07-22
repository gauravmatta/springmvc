package com.springimplant.currencyservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springimplant.currencyservice.contract.DeliveryPartnerData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerPhone {
	
	@KafkaListener(topics="customer",groupId = "customerGroup")
	public void customerDeliveryPartnerData(DeliveryPartnerData data) {
		log.info("Order Picked!!!");
		log.info("Total Distance: {}",data.getDistance());
		log.info("Estimated time to reach at your door: {}",data.getEstimatedTime());
		log.info(String.format("Message Consumed: %s",data));
		if(data.getXCoordinte()==0 && data.getYCoordinte()==0) {
			log.info("Delivery Partner has reached at your Location");
		}
	}
	
	@KafkaListener(topics="analytics",groupId = "customerGroup")
	public void customerAnalyticsData(DeliveryPartnerData data) {
		log.info(String.format("Message Consumed: %s",data));
		if(data.getXCoordinte()==0 && data.getYCoordinte()==0) {
			log.info("Delivery Partner has reached at Location");
		}
	}
}
