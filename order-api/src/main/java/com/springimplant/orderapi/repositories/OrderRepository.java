package com.springimplant.orderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.orderapi.entites.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
