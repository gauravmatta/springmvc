package com.springimplant.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
