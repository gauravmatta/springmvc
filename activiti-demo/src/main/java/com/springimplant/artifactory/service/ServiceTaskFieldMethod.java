package com.springimplant.artifactory.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceTaskFieldMethod implements JavaDelegate {
	
	private Expression name;
	private Expression amount;
	private Expression myval;

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("Name is : " + (String)name.getValue(execution));
		System.out.println("Amount is : " + (Long)amount.getValue(execution));
		System.out.println("My Value is : " + myval.getValue(execution).toString());
		long age = (Long) execution.getVariable("age");
		System.out.println("Age is : "+ age);
		execution.setVariable("approval","Rejected");
	}

}
