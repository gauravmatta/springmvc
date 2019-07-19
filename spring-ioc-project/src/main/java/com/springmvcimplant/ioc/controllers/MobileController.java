package com.springmvcimplant.ioc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvcimplant.ioc.entities.Airtel;
import com.springmvcimplant.ioc.entities.Vodafone;
import com.springmvcimplant.ioc.interfaces.Sim;

@Controller
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping("/")
	@ResponseBody
	public String home(Model model)
	{
		Sim sim=new Airtel();
		sim.calling();
		sim.data();
		sim=new Vodafone();
		sim.calling();
		sim.data();
		return "Welcome Mobile";
	}
	
	@RequestMapping("/airtel")
	@ResponseBody
	public String airtel()
	{
		//We are using separate classes here
		Airtel airtel=new Airtel();
		airtel.calling();
		airtel.data();
		return "Operations form Airtel";
	}
	
	@RequestMapping("/vodafone")
	@ResponseBody
	public String vodafone()
	{
		//We are using separate classes here 
		Vodafone voda=new Vodafone();
		voda.calling();
		voda.data();
		return "Operations form Vodafone";
	}
	
}
