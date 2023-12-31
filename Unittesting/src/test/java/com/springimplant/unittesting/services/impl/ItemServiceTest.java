package com.springimplant.unittesting.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springimplant.unittesting.data.ItemRepository;
import com.springimplant.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
	
	@InjectMocks
	private ItemServiceImpl service;
	
	@Mock
	private ItemRepository repository;

	@Test
	void retriveAllItems_basic() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(
						new Item(3,"Wickets",400,10),
						new Item(4,"Bails",100,10)
						));
		List<Item> items = service.retriveAllItems();
		assertEquals(4000,items.get(0).getValue());
		assertEquals(1000,items.get(1).getValue());
	}
}
