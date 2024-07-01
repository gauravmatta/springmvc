package com.springimplant.contract;

public interface mulint2 {
	default void result() {
		int x=5,y=13;
		int res = x*y;
		System.out.println("Result is :"+res);
	}
}
