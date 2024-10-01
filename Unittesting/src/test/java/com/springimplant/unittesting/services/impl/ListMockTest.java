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
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
	
	@Test
	void multipleArgumentCapturing() {
		mock.add("Item1");
		mock.add("Item2");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("Item1",allValues.get(0));
		assertEquals("Item2",allValues.get(1));
	}
	
	@Test
	void mocking() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Item");
		arrayListMock.add("Item1");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}
	
	@Test
	void spying() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Item0");
		System.out.println(arrayListSpy.get(0));//Item0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Item");
		arrayListSpy.add("Item1");
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		arrayListSpy.add("Item2");
		System.out.println(arrayListSpy.size());//5
		verify(arrayListSpy).add("Item2");
	}
}
