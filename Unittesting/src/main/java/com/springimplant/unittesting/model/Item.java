package com.springimplant.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Item {
	
	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	@Transient
	private int value;
}
