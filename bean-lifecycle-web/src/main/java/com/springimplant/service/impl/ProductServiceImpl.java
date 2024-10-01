package com.springimplant.service.impl;

import org.springframework.stereotype.Service;

import com.springimplant.entity.Product;
import com.springimplant.exceptions.NoProductFoundException;
import com.springimplant.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product findProductById(Integer pid) {
		if(pid==101) {
			return new Product(101,"Keyboard",800.00);
		}else {
			throw new NoProductFoundException("No Product Found");
		}
	}

}
