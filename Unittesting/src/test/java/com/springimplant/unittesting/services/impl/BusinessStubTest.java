package com.springimplant.unittesting.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.springimplant.unittesting.services.DataService;

class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class DataServiceEmptyStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class DataServiceOneElementStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}	
}

class BusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult= business.calculateSumUsingDataService();
		int expectedResult=6;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_empty() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceEmptyStub());
		int actualResult= business.calculateSumUsingDataService();
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_OneValue() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceOneElementStub());
		int actualResult= business.calculateSumUsingDataService();
		int expectedResult=5;
		assertEquals(expectedResult,actualResult);
	}

}
