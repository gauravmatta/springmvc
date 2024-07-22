package com.springimplant.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	void jsonAssert() {
		try {
			//Strict True Exact Fields Match Except for Spaces
			String expectedResponse="{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, true);
			//Strict False Partial Fields Match Except for Spaces
			expectedResponse="{\"id\": 1,\"name\":\"Ball\"}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, false);
			//Without Escape characters
			expectedResponse="{id: 1,name:Ball,price:10,quantity:100}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
