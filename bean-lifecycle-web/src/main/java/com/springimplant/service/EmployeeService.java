package com.springimplant.service;

import java.util.List;

import com.springimplant.dto.EmployeeDto;
import com.springimplant.entity.Employee;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto e);

	List<Employee> getAllEmployees();

	Employee getEmpById(Integer empId);

	void deleteEmpById(Integer empId);

}
