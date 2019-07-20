package com.springimplant.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.entities.Employee;
import com.springimplant.entities.Student;

public class Exam {

	public static void main(String args[])
	{
		//Using Getters and Setters Injection
//		Student student=new Student();
//		student.setStudentName("Gaurav Matta");
//		System.out.println(student);
		ApplicationContext context=new ClassPathXmlApplicationContext("/resources/beans.xml");
		Student gaurav=context.getBean("student",Student.class);
		System.out.println(gaurav);
		Student mohit=context.getBean("raghavi",Student.class);
		System.out.println(mohit);
		
		//Using Constructors Injection
//		Employee gautam=new Employee(1,"Gautam");
//		System.out.println(gautam);
		Employee gautam=context.getBean("employee",Employee.class);
		System.out.println(gautam);
		Employee billy=context.getBean("billy",Employee.class);
		System.out.println(billy);
	}
}
