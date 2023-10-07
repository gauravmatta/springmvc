package com.springimplant.mvc.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springimplant.mvc.model.Student;

import lombok.Data;

@Data
@EnableTransactionManagement
public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer insert(Student student) {
		return (Integer)this.hibernateTemplate.save(student);
	}
	
}
