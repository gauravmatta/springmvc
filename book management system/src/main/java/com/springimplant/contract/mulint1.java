package com.springimplant.contract;

public interface mulint1 {
	default void result() {
		int x=7,y=21;
		int res = x*y;
		System.out.println("Result is :"+res);
	}
}
