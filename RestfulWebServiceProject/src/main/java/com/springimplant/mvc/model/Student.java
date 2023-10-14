package com.springimplant.mvc.model;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("stu")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;
	
	@Value("Gaurav Matta")
	@Column(name = "student_name")
	private String studentName;
	
	@Value("19c")
	@Column(name = "street_address")
	private String streetAddress;
	
	@PostConstruct
	public void start() {
		System.out.println("Initializing Student "+this.studentName);
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Destroying Student "+this.studentName);
	}
	
}