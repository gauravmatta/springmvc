package com.springimplant.Cqrs_example.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.Cqrs_example.command.api.commands.CreateProductCommand;
import com.springimplant.Cqrs_example.command.api.model.ProductRestModel;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	private CommandGateway commandGateway;
	Logger log = LoggerFactory.getLogger(ProductCommandController.class);
	
	public ProductCommandController(CommandGateway commandGateway) {
		super();
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String addProduct(@RequestBody ProductRestModel productRestModel) {
		log.error("product Rest Model {}", productRestModel);
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
				.productId(UUID.randomUUID().toString())
				.name(productRestModel.getName())
				.price(productRestModel.getPrice())
				.quantity(productRestModel.getQuantity())
				.build();
		String result = commandGateway.sendAndWait(createProductCommand);
		return result;
	}

}
