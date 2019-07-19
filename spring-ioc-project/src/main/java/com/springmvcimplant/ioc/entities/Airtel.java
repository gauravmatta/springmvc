package com.springmvcimplant.ioc.entities;

import com.springmvcimplant.ioc.interfaces.Sim;

public class Airtel implements Sim {
	
	public Airtel()
	{
		System.out.println("setting Up Airtel");
	}

	@Override
	public void calling() 
	{
		System.out.println("Calling using Airtel Mobile");
	}

	@Override
	public void data() 
	{
		System.out.println("Using Airtel Data");
	}

}
