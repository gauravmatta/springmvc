package com.springimplant.unittesting.spike;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {
	
	@Test
	void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,45));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(100)));
		assertThat("",isEmptyString());
		assertThat("ABCDE",containsString("BCD"));
		assertThat("ABCDE",startsWith("ABCD"));
		assertThat("ABCDE",endsWith("CDE"));
	}

}
