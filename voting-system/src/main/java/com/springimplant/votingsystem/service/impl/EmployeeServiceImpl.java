package com.springimplant.votingsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springimplant.votingsystem.entity.Employee;
import com.springimplant.votingsystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public List<Employee> getAllEmployee() {
		LOGGER.info("Indise getAllEmployee method of Employee Service");
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee(1,"Gaurav",5000);
		Employee employee2 = new Employee(1,"Koti",7000);
		Employee employee3 = new Employee(1,"Laksh",9000);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		LOGGER.info("List of Emoployees : {}",employees);
		return employees;
	}

}
