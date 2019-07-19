package com.springmvcimplant.ioc.controllers;

import javax.servlet.http.HttpServletRequest;

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
public class HomeController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(HttpServletRequest request,Model model)
	{
//		System.out.println(request.getContextPath());
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Airtel air=(Airtel)applicationContext.getBean("airtel");
		air.calling();
		air.data();
		Vodafone v=applicationContext.getBean("voda",Vodafone.class);
		v.calling();
		v.data();
		Sim s1=applicationContext.getBean("sim",Sim.class);
		s1.calling();
		s1.data();
		return "Config Loaded";
	}
	
	@RequestMapping("/home")
	public String myhome()
	{
		return "home";
	}

}
