package com.springimplant.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void helloWorld_basic() {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);		
		try {
			MvcResult result = 
					mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().string("Hello World"))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			
			
//			   // Execute the GET request
//	        mockMvc.perform(get("/rest/widget/{id}", 1L))
//	                // Validate the response code and content type
//	                .andExpect(status().isOk())
//	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//	                // Validate headers
//	                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widget/1"))
//	                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
//
//	                // Validate the returned fields
//	                .andExpect(jsonPath("$.id", is(1)))
//	                .andExpect(jsonPath("$.name", is("Widget Name")))
//	                .andExpect(jsonPath("$.description", is("Description")))
//	                .andExpect(jsonPath("$.version", is(1)));
			
			
			
			assertEquals("Hello World",result.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
