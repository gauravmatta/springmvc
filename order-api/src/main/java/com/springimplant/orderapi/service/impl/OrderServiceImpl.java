package com.springimplant.orderapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.orderapi.entites.Order;
import com.springimplant.orderapi.exceptions.ResourceNotFoundException;
import com.springimplant.orderapi.repositories.OrderRepository;
import com.springimplant.orderapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order create(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order get(Long id) {
		return orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order with given id not found"));
	}

}
