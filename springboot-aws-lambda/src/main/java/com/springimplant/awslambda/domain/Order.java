package com.springimplant.awslambda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
private int id;
private String nameString;
private double price;
private int quantity;
}
