package com.springimplant.unittesting.services.impl;

import com.springimplant.unittesting.services.Business;

public class BusinessImpl implements Business{
	
	@Override
	public int calculatSum(int[] data) {
		int sum =0;
		for (int value:data) {
			sum += value;
		}
		return sum;
	}
}
