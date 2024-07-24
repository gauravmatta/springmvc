package com.springimplant.orderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springimplant.orderapi.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	public RestTemplate template;
	
	@Override
	public String invokeChat() {
		String url="http://emailapi/email/chat";
		return template.getForObject(url,String.class);
	}
	
	
}
