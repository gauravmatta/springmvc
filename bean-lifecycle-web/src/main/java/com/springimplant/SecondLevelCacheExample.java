package com.springimplant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springimplant.entity.Employee;
import com.springimplant.entity.Student;

public class SecondLevelCacheExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class,1);
		Employee emp1 = session1.get(Employee.class,103);
		System.out.println(emp1);
		System.out.println(student1);
		session1.close();
		
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class,1);
		Employee emp2 = session2.get(Employee.class,103);
		System.out.println(emp2);
		System.out.println(student2);
		session2.close();
		
	}
}
