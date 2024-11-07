package com.springimplant.unittesting.services.impl;

import java.util.Arrays;

import com.springimplant.unittesting.services.Business;
import com.springimplant.unittesting.services.DataService;

import lombok.Data;

@Data
public class BusinessImpl implements Business{
	
	private DataService dataService;
	
	@Override
	public int calculatSum(int[] data) {
		int sum =0;
		for (int value:data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingFunctionalCode(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	@Override
	public int calculateSumUsingDataService() {
		int sum =0;
		int [] data = dataService.retrieveAllData();
		for(int value:data ) {
			sum += value;
		}
		return sum;
	}
}
