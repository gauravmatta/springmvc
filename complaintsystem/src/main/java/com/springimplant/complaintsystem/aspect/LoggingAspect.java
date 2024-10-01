package com.springimplant.complaintsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.springimplant.complaintsystem.controllers.AppController.fileComplaint())")
	public void beforeLogger() {
		System.out.println("Before Loggers");
	}
	
	@After("execution(* com.springimplant.complaintsystem.controllers.AppController.fileComplaint())")
	public void afterLogger() {
		System.out.println("After Loggers");
	}
	
	@Before("execution(* com.springimplant.complaintsystem.controllers.AppController.submitComplaint(..))")
	public void beforesubmitComplaintLogger(JoinPoint jp) {
		System.out.println("Before Logger for Submitting Complaint");
		System.out.println(jp.getSignature());
		System.out.println(jp.getArgs()[0].toString());
	}

}
