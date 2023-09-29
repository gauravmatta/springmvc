package com.springimplant.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.ToString;

@ToString
public class Teacher {

//	Initialize Teacher Using Type
	@Autowired
//	To specify specific bean
	@Qualifier("delhi")
	private Address address;
	private List<Student> stulst;
	
//	Initialize using Constructor
//	@Autowired
	public Teacher(Address address, List<Student> stulst) {
		super();
		this.address = address;
		this.stulst = stulst;
		System.out.println("Initialize Teacher Using Constructor");
	}
	
	public List<Student> getStulst() {
		return stulst;
	}
	
//	Initialize using Setter
	@Autowired
	public void setStulst(List<Student> stulst) {
		this.stulst = stulst;
		System.out.println("Initialize Teacher Using Setter");
	}
}
