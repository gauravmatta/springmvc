package com.springimplant.unittesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
	private int id;
	private String name;
	private int price;
	private int quantity;
}
