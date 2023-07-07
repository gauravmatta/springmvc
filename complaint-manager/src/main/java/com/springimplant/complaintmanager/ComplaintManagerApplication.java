package com.springimplant.complaintmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class ComplaintManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintManagerApplication.class, args);
	}

}
