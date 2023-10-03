package com.springmvc.bms.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.bms.beans.Student;

import lombok.Data;

@Data
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		// insert data
		String query = "insert into student(id,studentName,streetAddress) values(?,?,?)";
		return this.jdbcTemplate.update(query,student.getStudentId(),student.getStudentName(),student.getStreetAddress());
	}

	@Override
	public int update(Student student) {
		//updating data
		String query = "update student set studentName=?, streetAddress=?  where id=?";
		return this.jdbcTemplate.update(query,student.getStudentName(),student.getStreetAddress(),student.getStudentId());
	}

}
