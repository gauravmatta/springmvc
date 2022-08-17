package com.springimplant.votingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {
	int id;
	String name;
	int salary;
}
