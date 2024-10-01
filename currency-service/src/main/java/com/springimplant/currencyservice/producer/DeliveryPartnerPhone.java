package com.springimplant.currencyservice.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springimplant.currencyservice.contract.DeliveryPartnerData;
import com.springimplant.currencyservice.contract.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliveryPartnerPhone {

	private KafkaTemplate<String, DeliveryPartnerData> kafkaTemplate;

	public DeliveryPartnerPhone(KafkaTemplate<String, DeliveryPartnerData> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publishDeliveryPartnerData(DeliveryPartnerData deliveryPartnerData) throws InterruptedException {
		while(deliveryPartnerData.getXCoordinte()!=0 || deliveryPartnerData.getYCoordinte()!=0) {
			log.info("Delivery Partner Coordinates :: X-Coordinte, Y-Coordinte {}",deliveryPartnerData.getXCoordinte(),deliveryPartnerData.getYCoordinte());
			Thread.sleep(500);
			if(deliveryPartnerData.getXCoordinte()==0) {
				deliveryPartnerData.setYCoordinte(deliveryPartnerData.getYCoordinte()-0.500);
			} 
			else if(deliveryPartnerData.getYCoordinte()==0) {
				deliveryPartnerData.setXCoordinte(deliveryPartnerData.getXCoordinte()-0.500);
			}else {
				deliveryPartnerData.setYCoordinte(deliveryPartnerData.getYCoordinte()-0.500);
				deliveryPartnerData.setXCoordinte(deliveryPartnerData.getXCoordinte()-0.500);
			}
			publishMessageToCustomer(deliveryPartnerData);
		}
	}
	
	public void publishMessageToCustomer(DeliveryPartnerData data) {
		Message<DeliveryPartnerData> messge = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC,"customer")
				.build();
		kafkaTemplate.send(messge);
		log.info("Message Published {}",data);
	}
	
	public void publishMessageToServiceProvider(DeliveryPartnerData data) {
		Message<DeliveryPartnerData> messge = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC,"serviceProvider")
				.build();
		kafkaTemplate.send(messge);
		log.info("Message Published {}",data);
	}
}
