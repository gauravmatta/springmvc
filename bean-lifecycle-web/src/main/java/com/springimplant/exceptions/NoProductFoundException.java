package com.springimplant.exceptions;

public class NoProductFoundException extends RuntimeException {

	private static final long serialVersionUID = 7869249979080850997L;
	
	public NoProductFoundException(String msg) {
		super(msg);
	}

}
