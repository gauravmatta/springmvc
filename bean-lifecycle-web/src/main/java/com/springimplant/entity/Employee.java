package com.springimplant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "Employee", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "EID")})
@Data
public class Employee {
	
	@Id
	@Column(name="EID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int EID;
	@Column(name="Names")
	private String Names;
	@Column(name="Salary")
	private long Salary;
}
