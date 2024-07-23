package com.springimplant.connectionpooling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.springimplant.connectionpooling.entity.Customers;
import com.springimplant.connectionpooling.projection.ICustomers;
import com.springimplant.connectionpooling.repository.CustomerRepository;
import com.springimplant.connectionpooling.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final int BATCH_SIZE = 100000;
	@Autowired
	private CustomerRepository repository;


	@Override
	public List<Customers> processCustomers() {
	    Slice<Customers> slice = repository.findAll(PageRequest.of(0, BATCH_SIZE));
	    List<Customers> customersInBatch = slice.getContent();
	    List<Customers> totalCustomers =  new ArrayList<Customers>();
	    totalCustomers.addAll(customersInBatch);
	    customersInBatch.stream().forEach(System.out::println);
	    while(slice.hasNext()) {
	        slice = repository.findAll(slice.nextPageable());
	        slice.get().forEach(System.out::println);
	        totalCustomers.addAll(slice.getContent());
	    }
	    return totalCustomers;
	}
}
