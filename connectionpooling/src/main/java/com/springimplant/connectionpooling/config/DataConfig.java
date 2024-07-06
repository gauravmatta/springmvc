package com.springimplant.connectionpooling.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.mbean.C3P0PooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataConfig {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

    @Bean
    @Primary
    DataSource hikariDataSource() {
		HikariDataSource dataSource= new HikariDataSource();
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
    
    @Bean
    DataSource dataSourceC3P0() {
    	ComboPooledDataSource dataSource= new ComboPooledDataSource();
		dataSource.setJdbcUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		return dataSource;
	}
    
    @Bean
    DataSource dataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean(value = "hikari")
	@Primary
	JdbcTemplate hikariJdbcTemplate() {
		return new JdbcTemplate(hikariDataSource());
	}
	
	@Bean(value = "c3p0")
	JdbcTemplate c3P0JdbcTemplate() {
		return new JdbcTemplate(dataSourceC3P0());
	}
}