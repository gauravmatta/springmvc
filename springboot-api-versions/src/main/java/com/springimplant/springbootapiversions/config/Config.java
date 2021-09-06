package com.springimplant.springbootapiversions.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class Config {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		UriTemplateHandler uriTemplateHandeler = new RootUriTemplateHandler("http://localhost:8001");
		return builder
				.uriTemplateHandler(uriTemplateHandeler)
				.setReadTimeout(Duration.ofMillis(1000))
				.build();
		
	}
}
