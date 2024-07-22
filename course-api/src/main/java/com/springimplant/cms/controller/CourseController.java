package com.springimplant.cms.controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.cms.entities.Course;
import com.springimplant.cms.repositories.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/")
	public String courseApiHome()
	{
		return "Course API Home";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return courseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Course getSpecificCourse(@PathVariable("id") BigInteger id)
	{
		return courseRepository.getOne(id);
	}
	
	@GetMapping("/optional/{id}")
	public Optional<Course> getSpecificOptionalCourse(@PathVariable("id") BigInteger id)
	{
		return courseRepository.findById(id);
	}
	
	@GetMapping("/staticcourses")
	public List<Course> getStaticCourses()
	{
		return Stream.of(new Course(1,"Java","Gaurav"),
				new Course(2,"Spring","Rohit"),
				new Course(3,"Hibernate","Mohit")).collect(Collectors.toList());
	}
	
	@PostMapping(value="/courses")
	public void saveCourse(@RequestBody Course course)
	{
		courseRepository.save(course);
	}
	
	@DeleteMapping(value="{id}")
	public void deleteCourse(@PathVariable BigInteger id)
	{
		courseRepository.deleteById(id);
	}
}
