package com.springimplant.votingsystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HazleCacheInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preCache invoked...{}:{}"+request.getRequestURI(),request.getMethod());
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		log.info(hazelcastInstance.toString());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	

}
