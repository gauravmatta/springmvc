package com.springmvc.bms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springmvc.bms.beans.Student;

import lombok.Data;

@Data
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// insert data
		String query = "insert into student(id,studentName,streetAddress) values(?,?,?)";
		return this.jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(),
				student.getStreetAddress());
	}

	@Override
	public int update(Student student) {
		// updating data
		String query = "update student set studentName=?, streetAddress=?  where id=?";
		return this.jdbcTemplate.update(query, student.getStudentName(), student.getStreetAddress(),
				student.getStudentId());
	}

	@Override
	public int delete(int studentId) {
		// delete data
		String query = "delete from student where id=?";
		return this.jdbcTemplate.update(query, studentId);
	}

	@Override
	public int deleteDuplicates() {
		String query = "Delete from student where id in (Select ds.id from (SELECT id,studentName,streetAddress, ROW_NUMBER() OVER(PARTITION BY id,studentName,streetAddress order by id,studentName,streetAddress) AS row_num  \n"
				+ "FROM springjdbc.student) ds where ds.row_num>1 )";
		return this.jdbcTemplate.update(query);
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "Select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		return this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		String query="Select * from student";
		return this.jdbcTemplate.query(query,new RowMapperImpl());
	}	
}