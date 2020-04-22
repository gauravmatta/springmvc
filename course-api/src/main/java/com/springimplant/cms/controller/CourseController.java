package com.springimplant.cms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.cms.entities.Course;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return Arrays.asList(new Course("100","course1","author1"),
				new Course("101","course2","author2"),
				new Course("102","course3","author3"));
	}
}
