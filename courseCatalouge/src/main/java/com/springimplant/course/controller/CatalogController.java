package com.springimplant.course.controller;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springimplant.course.core.Course;

@RestController
public class CatalogController {

	@GetMapping("/")
	public String getCatalogHome() {
		String courseAppMsg="";
		String courseUrl="http://localhost:8080/";
		RestTemplate restTemplate=new RestTemplate();
		courseAppMsg=restTemplate.getForObject(courseUrl,String.class);
		return("Welcome to Course Catalog "+courseAppMsg);
	}
	
	@GetMapping("/catalog")
	public String getCatalog() {
		String courses="";
		String courseUrl="http://localhost:8080/courses";
		RestTemplate restTemplate=new RestTemplate();
		courses=restTemplate.getForObject(courseUrl,String.class);
		return("Our Courses are "+courses);
	}
	
	@GetMapping("/catalogcourse/{id}")
	public String getCatalogCourse(@PathVariable("id") BigInteger id) {
		Course course=new Course();
		String courseUrl="http://localhost:8080/"+id;
		RestTemplate restTemplate=new RestTemplate();
		course=restTemplate.getForObject(courseUrl,Course.class);
		return("Our Course is "+ course.getCoursename()+" by "+course.getAuthor());
	}
}
