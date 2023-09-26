package com.springimplant.complaintmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication(scanBasePackages = "com.springimplant.complaintmanager")
@EnableEncryptableProperties
public class ComplaintManagerApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplicationBuilder.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ComplaintManagerApplication.class, args);
	}

}
