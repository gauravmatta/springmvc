package com.springimplant.unittesting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springimplant.unittesting.data.ItemRepository;
import com.springimplant.unittesting.model.Item;
import com.springimplant.unittesting.services.ItemService;

@Component
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item retriveHardcodedItem() {
		return new Item(2,"Bat",1500,10);
	}
	
	@Override
	public List<Item> retriveAllItems(){
		List<Item> items = itemRepository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
