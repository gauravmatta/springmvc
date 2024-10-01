package com.springimplant.orderapi.service;

import java.util.List;

import com.springimplant.orderapi.entites.Order;

public interface OrderService {
	Order create(Order order);
	List<Order> getAll();
	Order get(Long id);
}