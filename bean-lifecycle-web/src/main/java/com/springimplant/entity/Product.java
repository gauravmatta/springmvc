package com.springimplant.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "product", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "pid")})
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@AllArgsConstructor
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	@Column(name="pname")
	private String pname;
	@Column(name="price")
	private Double price;
}
