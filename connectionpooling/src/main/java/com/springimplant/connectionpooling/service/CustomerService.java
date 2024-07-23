package com.springimplant.connectionpooling.service;

import java.util.List;

import com.springimplant.connectionpooling.entity.Customers;

public interface CustomerService {
	
	List<Customers> processCustomers();
	
}