package com.springimplant.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.service.ShapeService;

public class AppMain 
{
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("/resources/spring.xml");
		ShapeService shapeService=context.getBean("shapeService",ShapeService.class);
		System.out.println(shapeService.getTriangle().getName());
	}
}
