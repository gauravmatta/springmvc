package com.springimplant.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springimplant.mvc.model.Student;

public class RowMapperImpl implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt(1));
		student.setStudentName(rs.getString(2));
		student.setStreetAddress(rs.getString(3));
		return student;
	}

}
