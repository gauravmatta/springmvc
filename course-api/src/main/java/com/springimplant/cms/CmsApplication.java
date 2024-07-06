package com.springimplant.cms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class CmsApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		System.out.println("userb=>"+encoder.encode("admin"));
	}

}
