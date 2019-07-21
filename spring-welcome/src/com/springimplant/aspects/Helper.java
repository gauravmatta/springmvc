package com.springimplant.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper 
{
	@Before("execution(public void cheating())")
	public void log()
	{
		System.out.println("show called");
	}
}
