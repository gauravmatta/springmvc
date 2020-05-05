package com.springimplant.course.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springimplant.course.core.Course;
import com.springimplant.course.core.User;

@RestController
public class CatalogController {
	
	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/")
	public String getCatalogHome() {
		String courseAppMsg="";
		String courseUrl="http://localhost:8080/";
		RestTemplate restTemplate=new RestTemplate();
		courseAppMsg=restTemplate.getForObject(courseUrl,String.class);
		return("Welcome to Course Catalog "+courseAppMsg);
	}
	
	@GetMapping("/services/cataloghome")
	@HystrixCommand(fallbackMethod = "displayDefaultHome")
	public String getCatalogHomeService() {
		String courseAppMsg="";
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-course-api",false);
		String courseUrl=instanceInfo.getHomePageUrl();
		RestTemplate restTemplate=new RestTemplate();
		courseAppMsg=restTemplate.getForObject(courseUrl,String.class);
		return("Welcome to Course Catalog "+courseAppMsg);
	}
	
	public String displayDefaultHome()
	{
		return("Welcome to SpringImplant"+" Please try after sometime");
	}
	
	@GetMapping("/catalog")
	public String getCatalog() {
		String courses="";
		String courseUrl="http://localhost:8080/courses";
		RestTemplate restTemplate=new RestTemplate();
		courses=restTemplate.getForObject(courseUrl,String.class);
		return("Our Courses are "+courses);
	}
	
	@GetMapping("/services/catalog")
	public String getCatalogService() {
		String courses="";
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-course-api",false);
		String courseUrl=instanceInfo.getHomePageUrl();
		courseUrl+="/courses";
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
	
	@GetMapping("/services/catalogcourse/{id}")
	public String getCatalogCourseService(@PathVariable("id") BigInteger id) {
		Course course=new Course();
		List<User> users=new ArrayList<User>();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-course-api",false);
		String courseUrl=instanceInfo.getHomePageUrl();
		courseUrl+="/"+id;
		RestTemplate restTemplate=new RestTemplate();
		course=restTemplate.getForObject(courseUrl,Course.class);
		instanceInfo=eurekaClient.getNextServerFromEureka("springimplant-user-api",false);
		String userAppUrl=instanceInfo.getHomePageUrl();
		userAppUrl=userAppUrl+"/"+course.getCourseid();
//		String userlist=restTemplate.getForObject(userAppUrl,String.class);
		users=restTemplate.getForObject(userAppUrl,List.class);
		return("Our Course is "+ course.getCoursename()+" by "+course.getAuthor()+" and the enrollled Users are "+users.toString());
	}
}
