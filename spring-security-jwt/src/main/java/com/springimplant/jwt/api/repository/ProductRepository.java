package com.springimplant.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.jwt.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
