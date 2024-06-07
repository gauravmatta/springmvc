package com.springimplant.deadletter.queue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing_key.name}")
	private String routing_key;

    @Bean
    Queue queue() {
		return new Queue(queue);
	}

    @Bean
    TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
    
    //Routing between Queue and Exchange using Routing Key
    @Bean
    Binding binding() {
    	return BindingBuilder.bind(queue())
    			.to(exchange())
    			.with(routing_key);
    }

    //ConnectionFactory
    //RabbitTemplate
    //RabbitAdmin
	
}
