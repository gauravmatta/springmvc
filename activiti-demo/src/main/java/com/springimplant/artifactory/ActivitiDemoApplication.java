package com.springimplant.artifactory;

import org.activiti.engine.ProcessEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ActivitiDemoApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(ActivitiDemoApplication.class, args);
	ProcessEngine processEngine = applicationContext.getBean(ProcessEngine.class);
	System.out.println("Initialized Application Context");
	}

}