package com.springimplant.unittesting.services;

import java.util.List;

import com.springimplant.unittesting.model.Item;

public interface ItemService {

	Item retriveHardcodedItem();

	List<Item> retriveAllItems();

}
