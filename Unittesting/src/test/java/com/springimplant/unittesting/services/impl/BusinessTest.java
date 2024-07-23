package com.springimplant.unittesting.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessTest {

	@Test
	void calculateSum_basic() {
		BusinessImpl business = new BusinessImpl();
		int actualResult= business.calculatSum(new int[] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSum_empty() {
		BusinessImpl business = new BusinessImpl();
		int actualResult= business.calculatSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSum_OneValue() {
		BusinessImpl business = new BusinessImpl();
		int actualResult= business.calculatSum(new int[] {5});
		int expectedResult=5;
		assertEquals(expectedResult,actualResult);
	}

}
