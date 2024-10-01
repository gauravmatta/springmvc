package com.springimplant.userapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.springimplant.userapi.dao.OrderDao;
import com.springimplant.userapi.service.OrderService;


@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<OrderDao> getOrders() {
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-coursecatalog",false);
		String catalougeUrl=instanceInfo.getHomePageUrl();
		System.out.println(catalougeUrl);
//		ResponseEntity<List<OrderDao>> dao=restTemplate.getForObject(catalougeUrl+"getorders",ResponseEntity.class);
		ResponseEntity<List<OrderDao>> dao=restTemplate.exchange(catalougeUrl+"getorders",HttpMethod.GET,null,new ParameterizedTypeReference<List<OrderDao>>() {});
		System.out.println(dao.getBody());
		return dao.getBody();
	}

}
