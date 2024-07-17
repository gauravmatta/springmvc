package com.springimplant.service.impl;

import org.springframework.stereotype.Service;

import com.springimplant.entity.Employee;
import com.springimplant.exceptions.EmptyInputException;
import com.springimplant.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Override
	public Employee addEmployee(Employee e) {
		if(e.getNames().isEmpty()|| e.getNames().length()==0) {
			throw new EmptyInputException("601","Input Fields are empty");
		}
		return e;
	}
}
