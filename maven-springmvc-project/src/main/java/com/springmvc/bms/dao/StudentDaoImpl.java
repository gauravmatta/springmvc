package com.springmvc.bms.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.bms.beans.Student;

import lombok.Data;

@Data
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		String query = "insert into student(id,studentName,streetAddress) values(?,?,?)";
		return this.jdbcTemplate.update(query,student.getStudentId(),student.getStudentName(),student.getStreetAddress());
	}

}
