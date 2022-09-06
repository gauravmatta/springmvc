package com.springimplant.awslambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.springimplant.awslambda.domain.Order;

@Repository
public class OrderDao {
public List<Order> buildOrders(){
	return Stream.of(
			new Order(101,"Mobile",20000,1),
			new Order(101,"Laptop",60000,1),
			new Order(101,"Speakers",10000,1),
			new Order(101,"Tablet",15000,1),
			new Order(101,"Tablet",6000,1)
			).collect(Collectors.toList());
}
}
