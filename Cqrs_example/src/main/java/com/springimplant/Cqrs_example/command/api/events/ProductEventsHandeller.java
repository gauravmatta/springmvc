package com.springimplant.Cqrs_example.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.springimplant.Cqrs_example.command.api.data.Product;
import com.springimplant.Cqrs_example.command.api.data.ProductRepository;

@Component
public class ProductEventsHandeller {

	private ProductRepository productRepository;
	Logger log = LoggerFactory.getLogger(ProductEventsHandeller.class);
	
	public ProductEventsHandeller(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		log.error("Event Found :", event.getName());
		Product product = new Product();
		BeanUtils.copyProperties(event, product);
		productRepository.save(product);
		
	}
}