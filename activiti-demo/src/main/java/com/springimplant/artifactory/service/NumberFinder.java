package com.springimplant.artifactory.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class NumberFinder implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		
		int x = (Integer) execution.getVariable("abc");
		System.out.println("Value of X is: " + x);
		System.out.println("From Java Class::"+ x);
		if((x%2) == 0) {
			System.out.println("Number is Even");
		} else {
			System.out.println("Number is Odd");
		}
	}

}
