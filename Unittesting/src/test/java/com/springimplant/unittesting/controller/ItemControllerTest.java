package com.springimplant.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springimplant.unittesting.model.Item;
import com.springimplant.unittesting.services.ItemService;
import com.springimplant.unittesting.services.impl.BusinessImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Test
	void dummyItem_basic() {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);		
		try {
			MvcResult result = 
					mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			JSONAssert.assertEquals("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}",result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void itemFromBusinessService_basic() {
		when(itemService.retriveHardcodedItem()).thenReturn(new Item(3,"Wickets",400,10));	
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);		
		try {
			MvcResult result = 
					mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().json("{id: 3,name:Wickets,price:400,quantity:10}"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			JSONAssert.assertEquals("{id: 3,name:Wickets,price:400,quantity:10}",result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
