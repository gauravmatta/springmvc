package com.springmvcimplant.ioc.entities;

import com.springmvcimplant.ioc.interfaces.Sim;

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
