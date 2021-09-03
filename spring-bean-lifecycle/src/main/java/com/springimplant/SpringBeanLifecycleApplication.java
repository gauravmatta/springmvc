package com.springimplant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springimplant.beans.HelloWorldBean;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
		context.stop();
		context.close();
		
		
		ApplicationContext rootContext=SpringApplication.run(SpringBeanLifecycleApplication.class, args);
		HelloWorldBean helloWorldBean=rootContext.getBean(HelloWorldBean.class);
		helloWorldBean.printHelloWorld();
	}

}
