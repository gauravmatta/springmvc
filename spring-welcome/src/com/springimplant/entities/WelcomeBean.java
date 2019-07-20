package com.springimplant.entities;

public class WelcomeBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void show()
	{
		System.out.println(message);
	}

}
