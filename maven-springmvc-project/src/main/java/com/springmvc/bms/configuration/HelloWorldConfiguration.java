package com.springmvc.bms.configuration;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages="com.springmvc.bms")
public class HelloWorldConfiguration {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	@Bean(name = "absentAttendence")
	public List<String> presentAttendence() {
		List<String> attendence = new LinkedList<String>();
		attendence.add("0");
		attendence.add("0");
		attendence.add("0");
		attendence.add("0");
		attendence.add("0");
		return attendence;
	}
	
	@Bean(name = "alldistinction")
	public Map<String,String> alldistinction() {
		Map<String,String> marks = new HashMap<>();
		marks.put("Maths", "75");
		marks.put("English", "75");
		marks.put("Hindi", "75");
		marks.put("Knowledge", "75");
		return marks;
	}
	
	@Bean(name = "subjects")
	public Set<String> subjects() {
		Set<String> subjects = new LinkedHashSet<>();
		subjects.add("Maths");
		subjects.add("English");
		subjects.add("Hindi");
		subjects.add("Knowledge");
		return subjects;
	}
}