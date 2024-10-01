package com.springimplant.connectionpooling.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customers {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "customer_name")
	private String customer_name;
	
	@Column(name="created_at", nullable=false)
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd H:m:s")
//	@Convert(converter = DateConverter.class)
	public String created_at;
	
//	@PrePersist
//	protected void onCreate() {
//	    created_at = LocalDate.now().toString();
//	}
	
}
