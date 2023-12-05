package com.springimplant.unittesting.services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@Test
	void size_basic(){
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	void returnDifferentValues(){
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}

	@Test
	void returnWithParameters() {
		when(mock.get(0)).thenReturn("Spring Implant");
		assertEquals("Spring Implant",mock.get(0));
		assertEquals(null,mock.get(1));
	}
	
	@Test
	void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Spring Implant");
		assertEquals("Spring Implant",mock.get(0));
		assertEquals("Spring Implant",mock.get(1));
	}
	
	@Test
	void verificationBasics() {		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(2)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
// Will Fail as we are calling more than once
//		verify(mock, atMostOnce()).get(anyInt());
		verify(mock, never()).get(2);
// Will Fail as we are calling value 2 times
//		verify(mock, times(1)).get(anyInt());
	}
	
	@Test
	void argumentCapturing() {
		mock.add("Item1");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("Item1",captor.getValue());
	}
	
	
}
