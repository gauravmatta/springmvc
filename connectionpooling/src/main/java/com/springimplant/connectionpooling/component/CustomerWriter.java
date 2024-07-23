package com.springimplant.connectionpooling.component;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springimplant.connectionpooling.entity.Customers;
import com.springimplant.connectionpooling.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerWriter implements ItemWriter<Customers> {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void write(Chunk<? extends Customers> chunk) throws Exception {
		log.info("Thread Name:"+Thread.currentThread().getName());
		customerRepository.saveAll(chunk.getItems());
	}
	

}
