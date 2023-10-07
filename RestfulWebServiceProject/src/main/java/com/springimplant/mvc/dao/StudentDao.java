package com.springimplant.mvc.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springimplant.mvc.model.Student;

import lombok.Data;

@Data
public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	public Integer insert(Student student) {
		return (Integer)this.hibernateTemplate.save(student);
	}
	
}
