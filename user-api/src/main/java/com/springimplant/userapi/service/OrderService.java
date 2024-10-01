package com.springimplant.userapi.service;

import java.util.List;

import com.springimplant.userapi.dao.OrderDao;



public interface OrderService {
	public List<OrderDao> getOrders();
}
