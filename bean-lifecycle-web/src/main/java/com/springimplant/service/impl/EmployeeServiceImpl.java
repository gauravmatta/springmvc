package com.springimplant.service.impl;

import org.springframework.stereotype.Service;

import com.springimplant.dto.EmployeeDto;
import com.springimplant.entity.Employee;
import com.springimplant.exceptions.EmptyInputException;
import com.springimplant.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto e) {
		log.info("====================>"+e.toString());
		if(e.getNames().isEmpty()|| e.getNames().length()==0) {
			throw new EmptyInputException("601","Input Fields are empty");
		}
		return e;
	}
}
