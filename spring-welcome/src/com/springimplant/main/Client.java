package com.springimplant.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.entities.Pupil;
import com.springimplant.entities.Student;

public class Client 
{
	public static void main(String args[])
	{
//		Student student=new Student();
//		Cheating cheat=new Cheating();
//		student.setCheat(cheat);
		ApplicationContext context= new ClassPathXmlApplicationContext("/resources/object_injection.xml");
		Student student=context.getBean("stu",Student.class);
		student.cheating();
		System.out.println(student);
		
		Pupil pupil=context.getBean("pupil",Pupil.class);
		pupil.startCheating();
		System.out.println(pupil);
	}
}