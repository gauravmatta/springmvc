package com.springimplant.unittesting.services.impl;

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
