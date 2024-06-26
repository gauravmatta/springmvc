package com.springimplant.main;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.config.HelloWorld;

public class MyApp {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/beans.xml")) {
			context.start();
			HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
			obj.getMessage();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
