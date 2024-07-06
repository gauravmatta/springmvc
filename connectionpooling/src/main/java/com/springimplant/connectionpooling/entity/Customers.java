package com.springimplant.connectionpooling.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Customers {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
	
	@Column(name = "customer_name")
	private String customer_name;
	
	@Column(name="created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdAt;
	
	@PrePersist
	protected void onCreate() {
	    createdAt = new Date();
	}
	
}
