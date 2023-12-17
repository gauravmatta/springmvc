package com.springimplant.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Item {
	
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
}
