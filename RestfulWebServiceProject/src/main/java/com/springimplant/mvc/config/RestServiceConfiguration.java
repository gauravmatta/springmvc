package com.springimplant.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springimplant.mvc.dao.StudentDaoImpl;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages="com.springmvc.bms")
@PropertySource("classpath:db.properties")
public class RestServiceConfiguration {
	
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
		source.setUrl("jdbc:mysql://localhost:3306/restservice");
		source.setUsername("root");
		source.setPassword("root@04G");
		return source;
	}
}