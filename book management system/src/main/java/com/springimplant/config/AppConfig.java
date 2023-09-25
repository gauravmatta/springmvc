package com.springimplant.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springimplant.model.Student;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.springimplant.dao"),
		@ComponentScan("com.springimplant.service")
})
public class AppConfig {
	public static void main(String[] args) {
		System.out.println("Hello Main World!");
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/config.xml");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/config.xml")) {
			Student s = (Student) context.getBean("Student1");
			System.out.println(s.toString());
			}
	}
}
