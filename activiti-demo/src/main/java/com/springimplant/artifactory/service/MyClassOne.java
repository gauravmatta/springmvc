package com.springimplant.artifactory.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyClassOne implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		String name = (String) execution.getVariable("name");
		System.out.println("Hello "+ name);
	}

}
