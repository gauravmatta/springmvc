package com.springimplant.deadletter.queue.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.json.queue.name}")
	private String json_queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing_key.name}")
	private String routing_key;
	
	@Value("${rabbitmq.json.routing_key.name}")
	private String routing_json_key;

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
    
    @Bean
    Queue jsonQueue() {
    	return new Queue(json_queue);
    }
    
    //Routing between json Queue and Exchange using Routing Key
    @Bean
    Binding json_binding() {
    	return BindingBuilder.bind(jsonQueue())
    			.to(exchange())
    			.with(routing_json_key);
    }

    @Bean
    MessageConverter converter() {
    	return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	rabbitTemplate.setMessageConverter(converter());
    	return rabbitTemplate;
    }

    //ConnectionFactory
    //RabbitTemplate
    //RabbitAdmin
}
