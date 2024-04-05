package com.springimplant.awslambda.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springimplant.awslambda.domain.Student;

@Repository
public class StudentRepository {
	public List<Student> list(){
		return Arrays.asList(new Student(1,"Samuel",55),
				new Student(2,"Matt",67),
				new Student(3,"Booker",34));
	}
}
