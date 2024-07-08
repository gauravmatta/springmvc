package com.springimplant.connectionpooling.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.springimplant.connectionpooling.converter.DateConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
