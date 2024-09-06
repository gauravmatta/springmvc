package com.springimplant.orderapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2554818748321223299L;
	
	public ResourceNotFoundException(String s) {
		super(s);
	}
	
	public ResourceNotFoundException() {
		super("Resource Not Found");
	}
}