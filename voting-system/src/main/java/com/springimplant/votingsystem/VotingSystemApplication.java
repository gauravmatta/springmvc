package com.springimplant.votingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ImportResource("classpath:app-config.xml")
public class VotingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
	}

}
