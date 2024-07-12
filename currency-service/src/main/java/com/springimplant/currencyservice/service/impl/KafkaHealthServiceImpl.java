package com.springimplant.currencyservice.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springimplant.currencyservice.service.HealthService;

import lombok.extern.slf4j.Slf4j;

@Service("kafkaservice")
@Slf4j
public class KafkaHealthServiceImpl implements HealthService {
	
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.health.indicator.timeout.ms:100}")
    private int timeout;

    public KafkaHealthServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    void postConstruction() {
        log.info("[KafkaHealthIndicator] timeout: {}", timeout);
    }
	
	@Override
	public Health health() {
			  try {
				kafkaTemplate.send("kafka-health-indicator","❥").get(timeout, TimeUnit.MILLISECONDS);
			}catch (ExecutionException|InterruptedException|TimeoutException e) {
	            log.error("[kafka-health-indicator]: Kafka Health Down! Caught cause: {}", e);
	            Thread.currentThread().interrupt();
	            return Health.down(e)
	            		.withDetail("kafka Service","Kafka Service is Down")
	            		.build();
	        }
	        return Health.up()
	        		.withDetail("Kafka Servie","Kafka Service is Running")
	        		.build();
	    }
}
