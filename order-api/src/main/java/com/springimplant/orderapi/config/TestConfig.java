package com.springimplant.orderapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springimplant.orderapi.interceptor.TestInterceptor;

@Configuration
public class TestConfig implements WebMvcConfigurer {
	
	@Autowired
	private TestInterceptor interceptor;

//	public TestConfig(TestInterceptor interceptor) {
//		super();
//		this.interceptor = interceptor;
//	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
}
