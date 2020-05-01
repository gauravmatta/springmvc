package com.springimplant.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseCatalougeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseCatalougeApplication.class, args);
	}
}
