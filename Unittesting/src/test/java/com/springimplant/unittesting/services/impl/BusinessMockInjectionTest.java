package com.springimplant.unittesting.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springimplant.unittesting.services.DataService;

@ExtendWith(MockitoExtension.class)
class BusinessMockInjectionTest {
	
	@InjectMocks
	BusinessImpl business;
	
	@Mock
	DataService dataServiceMock;
	

	@Test
	void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6,business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0,business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumUsingDataService_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5,business.calculateSumUsingDataService());
	}

}
