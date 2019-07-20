package com.springimplant.entities;

import com.springimplant.interfaces.Sim;

public class Jio implements Sim{

	@Override
	public void calling() {
		
		System.out.println("Calling using Jio Mobile");
	}

	@Override
	public void data() {
		
		System.out.println("Calling using Jio Data");
		
	}

}
