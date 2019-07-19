package com.springmvcimplant.ioc.entities;

import com.springmvcimplant.ioc.interfaces.Sim;

public class Vodafone implements Sim{

	@Override
	public void calling() {
		
		System.out.println("Calling using Vodafone Mobile");
	}

	@Override
	public void data() {
		
		System.out.println("Calling using Vodafone Data");
		
	}

}
