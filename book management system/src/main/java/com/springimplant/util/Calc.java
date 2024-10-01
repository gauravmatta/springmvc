package com.springimplant.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Calc {
	private int a;
	private int b;
	
	public Calc(double a,double b) {
		this.a =(int) a;
		this.b=(int) b;
		System.out.println("Constructor: double, double");
	}
	
	public Calc(int a,int b) {
		this.a =a;
		this.b=b;
		System.out.println("Constructor: int, int");
	}
	
	public Calc(String a,String b) {
		this.a =Integer.parseInt(a);
		this.b=Integer.parseInt(b);
		System.out.println("Constructor: String, String");
	}
	
	public void doSum() {
		System.out.println("Value of A"+ this.a);
		System.out.println("Value of B"+ this.b);
		System.out.println("Sum is"+ (this.a+this.b));
	}
}
