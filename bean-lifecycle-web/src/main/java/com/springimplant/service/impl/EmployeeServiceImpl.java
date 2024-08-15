package com.springimplant.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.dto.EmployeeDto;
import com.springimplant.entity.Employee;
import com.springimplant.exceptions.EmptyInputException;
import com.springimplant.repositories.EmployeeRepository;
import com.springimplant.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	private ModelMapper mapper;
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto e) {
		log.info("====================>"+e.toString());
		this.mapper = new ModelMapper();
		if(e.getNames().isEmpty() || e.getNames().length()==0) {
			throw new EmptyInputException("601","Input Fields are empty");
		}
		Employee employee = mapper.map(e,Employee.class);
		repository.save(employee);
		return e;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> empList = repository.findAll();
		if(empList.isEmpty()) {
//			throw new BusinessException("604","Hey List is completely empty. We have nothing");
		}
		return empList;
	}
	
	@Override
	public Employee getEmpById(Integer empId) {
		Employee e = repository.findById(empId);
		if(e==null) {
			throw new NoSuchElementException();
		}
		return e;
	}
	
	@Override
	public void deleteEmpById(Integer empId) {
		repository.delete(empId);
	}
	
	
	
}
