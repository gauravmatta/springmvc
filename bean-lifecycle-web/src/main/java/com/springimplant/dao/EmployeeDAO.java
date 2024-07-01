package com.springimplant.dao;

import java.util.List;

import com.springimplant.entity.Employee;

public interface EmployeeDAO {
	public void save(Employee p);
	public List<Employee> list();
}
