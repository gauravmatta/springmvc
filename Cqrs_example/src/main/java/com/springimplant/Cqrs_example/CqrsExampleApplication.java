package com.springimplant.Cqrs_example;

import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springimplant.Cqrs_example.command.api.exception.ProductServiceEventsErrorHandler;

@SpringBootApplication
public class CqrsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsExampleApplication.class, args);
	}
	
	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler("product", configuration -> new ProductServiceEventsErrorHandler());
	}

}
