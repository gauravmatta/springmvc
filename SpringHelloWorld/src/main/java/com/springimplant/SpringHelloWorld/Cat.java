package com.springimplant.SpringHelloWorld;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Meaw");
	}

}
