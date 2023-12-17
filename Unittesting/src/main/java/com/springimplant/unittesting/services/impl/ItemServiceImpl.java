package com.springimplant.unittesting.services.impl;

import org.springframework.stereotype.Component;

import com.springimplant.unittesting.model.Item;
import com.springimplant.unittesting.services.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	@Override
	public Item retriveHardcodedItem() {
		return new Item(2,"Bat",1500,10);
	}

}
