package com.springimplant.course.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.springimplant.course.entity.Order;
import com.springimplant.course.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getOrders() {
		return Stream.of(
				new Order("JEE","JEE","30 Months",25000),
				new Order("Java","Java","10 Months",15000),
				new Order("Spring","Java","10 Months",30000),
				new Order("IAS Mains","Mains","2 Years",50000),
				new Order("C Plus Plus","C","5 Months",10000)
				).collect(Collectors.toList());
	}

}
