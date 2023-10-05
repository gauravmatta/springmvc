package com.springmvc.bms.dao;

import java.util.List;

import com.springmvc.bms.beans.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int studentId);
	public int deleteDuplicates();
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
}
