package com.springimplant.connectionpooling;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class ConnectionpoolingApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("hikari")
	private JdbcTemplate jdbcTemplateHikari;

	@Autowired
	@Qualifier("c3p0")
	private JdbcTemplate jdbcTemplatec3p0;

	public static void main(String[] args) {
		SpringApplication.run(ConnectionpoolingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.update("INSERT INTO bms.Employee (Names, Salary) VALUES('Gautam', 200000)");
		jdbcTemplatec3p0.update("INSERT INTO bms.Employee (Names, Salary) VALUES('Rambo', 400000)");
		List<Map<String, Object>> queryForList = jdbcTemplateHikari.queryForList("SELECT EID, Names, Salary FROM bms.Employee");
		queryForList.stream().flatMap(Stream::of).forEach(System.out::println);
	}

}
