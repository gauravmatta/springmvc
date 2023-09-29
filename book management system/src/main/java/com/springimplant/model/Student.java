package com.springimplant.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String streetAddress;
	private Address address;
	private List<String> weekAttendence;
	private Set<String> subjects;
	private Map<String,String> marks;
	Properties attendenceKeys = new Properties();
	Subject favorites;
	
	@PostConstruct
	public void start() {
		System.out.println("Initializing Student "+this.studentName);
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Destroying Student "+this.studentName);
	}
	
}