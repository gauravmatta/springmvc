package com.springmvc.bms.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.bms.beans.Student;
import com.springmvc.bms.beans.Subject;
import com.springmvc.bms.configuration.HelloWorldConfiguration;



public class Project {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			Student s1 = context.getBean("stu",Student.class);
			System.out.println(s1.toString());
			Subject sub = context.getBean("subject",Subject.class);
			System.out.println(sub.toString());
			context.close();
		}
	}
}