package com.springimplant.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.entities.Student;

public class LooseCoupling {
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("/resources/LooseCoupling.xml");
		Student stu=(Student) context.getBean("stu",Student.class);
		stu.getCheatingInterface().cheating();
	}
}
