package com.springimplant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
//		context.stop();
//		context.close();
//		SpringApplication.run(SpringBeanLifecycleApplication.class, args);
	}

}
