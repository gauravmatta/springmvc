package com.springimplant.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.unittesting.model.Item;
import com.springimplant.unittesting.services.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/dummy-item")
	public Item helloWorld() {
		return new Item(1,"Ball",10,100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return itemService.retriveHardcodedItem();
	}
}
