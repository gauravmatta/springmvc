package com.springimplant.main;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springimplant.config.HelloWorld;

public class MyApp {

	public static void main(String[] args) {
		String parent =null;
		File file = new File(parent,"myfile.txt");
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/beans.xml")) {
			context.start();
			HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
			obj.getMessage();
			file.createNewFile();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
