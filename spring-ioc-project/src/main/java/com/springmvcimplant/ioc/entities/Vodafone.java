package com.springmvcimplant.ioc.entities;

import com.springmvcimplant.ioc.interfaces.Sim;

public class Vodafone implements Sim{

	public void calling() {
		
		System.out.println("Calling using Vodafone Mobile");
	}

	public void data() {
		
		System.out.println("Calling using Vodafone Data");
		
	}

}
