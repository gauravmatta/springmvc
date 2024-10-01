package com.springimplant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.entity.Product;
import com.springimplant.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getProduct",produces = {"application/json"})
	public Product getProductData(@RequestParam("pid") String pid) {
		return productService.findProductById(Integer.parseInt(pid));
	}
}
