package com.springimplant.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String getCatalogService() {
		String currency="";
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-currency-service",false);
		String currencyUrl=instanceInfo.getHomePageUrl();
		currency=restTemplate.getForObject(currencyUrl,String.class);
		return("Currency value is coming from port "+currency);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
