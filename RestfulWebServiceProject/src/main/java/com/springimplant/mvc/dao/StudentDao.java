package com.springimplant.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springimplant.mvc.model.Student;

@Component("studentDao")
public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int studentId);
	public int deleteDuplicates();
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
}
