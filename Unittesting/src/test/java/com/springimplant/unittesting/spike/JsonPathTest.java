package com.springimplant.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JsonPathTest {
	
	@Test
	void learning() {
		String responseFromService="["
				+ "{"
				+ "\"id\":10000,"
				+ "\"name\":\"Pencil\","
				+ "\"quantity\": 5"
				+ "},"
				+ "{"
				+ "\"id\":10001,"
				+ "\"name\":\"Pen\","
				+ "\"quantity\": 3"
				+ "},"
				+ "{"
				+ "\"id\":10002,"
				+ "\"name\":\"Eraser\","
				+ "\"quantity\": 15"
				+ "},"
				+ "{"
				+ "\"id\":10003,"
				+ "\"name\":\"Sharpner\","
				+ "\"quantity\": 13"
				+ "}"
				+ "]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(4);
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10000,10001,10002,10003);
		System.out.println(ids.toString());
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(context.read("$.[?(@.quantity==13)]").toString());
	}

}
