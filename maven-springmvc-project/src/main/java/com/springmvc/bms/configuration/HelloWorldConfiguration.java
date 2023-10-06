package com.springmvc.bms.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.springmvc.bms.beans.Book;
import com.springmvc.bms.beans.Subject;
import com.springmvc.bms.dao.StudentDaoImpl;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages="com.springmvc.bms")
@PropertySource("classpath:db.properties")
public class HelloWorldConfiguration {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	@Bean(name="StudentDaoImpl")
	public StudentDaoImpl setsdao() {
		StudentDaoImpl simpl = new StudentDaoImpl();
		simpl.setJdbcTemplate(jdbcTemplate());
		return simpl;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		DriverManagerDataSource myds = ds();
		template.setDataSource(myds);
		return template;
	}
	
	@Bean("ds")
	public DriverManagerDataSource ds() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		source.setUsername("root");
		source.setPassword("root@04G");
		return source;
	}
	
	@Bean(name = "absentAttendence")
	public List<String> presentAttendence() {
		List<String> attendence = new LinkedList<>();
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
	
	@Bean(name= "alphabets")
	public Book getBookAlphabets() {
		return new Book(1,"Alphabets Writing","Raj Comics", 50);
	}
	
	@Bean(name= "phonics")
	public Book getBookPhonics() {
		return new Book(2,"Phonics","EduServe", 100);
	}
	
	@Bean(name="engbooks")
	public List<Book> books(){
		List<Book> bks = new ArrayList<>();
		bks.add(getBookAlphabets());
		bks.add(getBookPhonics());
		return bks;
	}
	
	@Bean(name="subject")
	public Subject getSubject(){
		List<Book> bks = books();
		return new Subject(bks);
	}
}