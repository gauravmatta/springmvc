package com.springimplant.main;

import com.springimplant.contract.mulint1;
import com.springimplant.contract.mulint2;

public class Multiplication implements mulint1,mulint2 {
	public void result() {
		mulint1.super.result();
		mulint2.super.result();
	}
	public static void main(String args[]) {
		Multiplication d = new Multiplication();
		d.result();
	}
}
