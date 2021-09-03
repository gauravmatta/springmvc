package com.springimplant.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	@PostConstruct
	public void start() {
		System.out.println("start method called...");
	}
	
	public void myMethod() {
		System.out.println("my method executing...");
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("stop method called...");
	}

}
