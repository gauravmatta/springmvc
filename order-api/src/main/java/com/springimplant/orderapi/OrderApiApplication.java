package com.springimplant.orderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.springimplant.orderapi.config.RibbonConfiguration;

@SpringBootApplication
//@RibbonClient(name="emailapi",configuration = RibbonConfiguration.class)
public class OrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApiApplication.class, args);
	}

}
