package com.springimplant.artifactory.service;

import java.io.Serializable;

public class MyClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String myMethod(String name) {
		return "Hello+++++" + name;
	}

}
