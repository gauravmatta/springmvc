package com.springimplant.votingsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springimplant.votingsystem.interceptor.GeneralInterceptor;
import com.springimplant.votingsystem.interceptor.HazleCacheInterceptor;
import com.springimplant.votingsystem.interceptor.VotingInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	GeneralInterceptor generalInterceptor;
	
	@Autowired
	VotingInterceptor votingInterceptor;
	
	@Autowired
	HazleCacheInterceptor cacheInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(generalInterceptor).addPathPatterns("/");
//		registry.addInterceptor(votingInterceptor).addPathPatterns("/employees");
//		registry.addInterceptor(cacheInterceptor).addPathPatterns("/candidate/*");
//		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
