package com.springimplant.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		String response = this.restTemplate.getForObject("/all-items-from-database",String.class);
		try {
			JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
