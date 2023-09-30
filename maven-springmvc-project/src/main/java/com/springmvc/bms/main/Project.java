package com.springmvc.bms.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.bms.beans.Student;
import com.springmvc.bms.configuration.HelloWorldConfiguration;



public class Project {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			Student s1 = (Student) context.getBean("stu");
			System.out.println(s1.toString());
			context.close();
		}
	}
}