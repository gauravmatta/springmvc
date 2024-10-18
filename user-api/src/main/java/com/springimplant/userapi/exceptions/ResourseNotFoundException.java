package com.springimplant.userapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6750841804830328386L;
	
	public ResourseNotFoundException() {
		super("Resource not found on server !!");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
