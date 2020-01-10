package com.springimplant.mvc.interceptors;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springimplant.mvc.HitCounter;

public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	@Resource 
	private HitCounter RequestHit;
	
	@Resource
	private HitCounter applicationHit;
	
	@Resource
	private HitCounter sessionHit;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		RequestHit.setHits(RequestHit.getHits()+1);
		System.out.println("Request Hits "+RequestHit.getHits());
		applicationHit.setHits(applicationHit.getHits()+1);
		System.out.println("Application Hits "+applicationHit.getHits());
		sessionHit.setHits(sessionHit.getHits()+1);
		System.out.println("Session Hits "+sessionHit.getHits());
		// Moved to Controller Advice
//		request.setAttribute("currentDate",new Date());
		return super.preHandle(request, response, handler);
	}

}
