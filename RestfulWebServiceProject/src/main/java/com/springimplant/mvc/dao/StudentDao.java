package com.springimplant.mvc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springimplant.mvc.model.Student;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@EnableTransactionManagement
public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer insert(Student student) {
		return (Integer)this.hibernateTemplate.save(student);
	}
	
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}
	
	public List<Student> getAllStudents(){
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	@Transactional
	public void deleteStudent(int studentId) {
		Student stu = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(stu);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
}
