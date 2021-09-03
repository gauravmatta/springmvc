package com.springimplant.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {
	
	@PostConstruct
	public void start() {
		System.out.println("Hello World Bean constructed...");
	}

	public void printHelloWorld()
	{
		for(int i=0;i<20;i++) {
			System.out.println("Hello World -"+i);
		}
	}
}
