package com.springimplant.kafkacluster.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic mytopic() {
		return TopicBuilder.name("springimplantTopic")
				.build();
	}
    
    @Bean
    NewTopic myJSONtopic() {
		return TopicBuilder.name("springimplantJsonTopic")
				.build();
	}
    
    @Bean
    NewTopic customer() {
		return TopicBuilder.name("customer")
				.build();
	}
    
    @Bean
    NewTopic serviceProvider() {
		return TopicBuilder.name("serviceProvider")
				.build();
	}
    
    @Bean
    NewTopic deliveryAnalytics() {
		return TopicBuilder.name("analytics")
				.build();
	}
    
    
}
