package com.springimplant.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() {
		try {
			// Strict True Exact Fields Match Except for Spaces
			String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	void jsonAssert_StrictFalse() {
		try {
			// Strict False Partial Fields Match Except for Spaces
			String expectedResponse = "{\"id\": 1,\"name\":\"Ball\"}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	void jsonAssert_WithoutEscapeCharacters() {
		try {
			// Without Escape characters
			String expectedResponse = "{id: 1,name:Ball,price:10,quantity:100}";
			JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
