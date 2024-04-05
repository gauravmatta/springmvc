package com.springimplant.Cqrs_example.command.api.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.springimplant.Cqrs_example.command.api.commands.CreateProductCommand;
import com.springimplant.Cqrs_example.command.api.events.ProductCreatedEvent;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aggregate
public class ProductAggregate {
	
	@AggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	Logger log = LoggerFactory.getLogger(ProductAggregate.class);
	
	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		super();
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		log.error("product Command {}", createProductCommand);
		log.error("product Event {}", productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	public ProductAggregate() {
		super();
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		log.error("Sourcing Events on :", productCreatedEvent.getName());
		this.quantity=productCreatedEvent.getQuantity();
		this.productId=productCreatedEvent.getProductId();
		this.price=productCreatedEvent.getPrice();
		this.name=productCreatedEvent.getName();
	}
	
	
}
