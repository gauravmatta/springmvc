package com.springimplant.connectionpooling.component;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springimplant.connectionpooling.entity.Customers;

@Component
public class CustomerProcessor implements ItemProcessor<Customers, Customers> {

	@Override
	public Customers process(Customers item) throws Exception {
		String name = item.getCustomer_name();
		if((name.charAt(name.length() - 1))=='2') {
			return item;
		}
		return null;
	}
	
}
