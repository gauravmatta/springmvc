package com.springimplant.complaintsystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class AuthenticationAspect {

	@Pointcut("within(com.springimplant.complaintsystem..*)")
	public void authenticatingPointCut() {
		
	}
	
	@Pointcut("within(com.springimplant.complaintsystem..*)")
	public void authorizationPointCut() {
		
	}
	
	@Before("authenticatingPointCut() && authorizationPointCut()")
	public void Authenticate() {
		System.out.println("Authenticating the request");
	}
	
}
