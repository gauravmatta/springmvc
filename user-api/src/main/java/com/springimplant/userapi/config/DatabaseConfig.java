//package com.springimplant.userapi.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//public class DatabaseConfig {
//
////	@Bean
////    @Primary
////    @ConfigurationProperties("spring.datasource.postgres")
////    DataSource postgresDataSource() {
////        return DataSourceBuilder.create().build();
////    }
////
////    @Bean(value = "postgresJdbcTemplate")
////	@Primary
////	JdbcTemplate hikariJdbcTemplate() {
////		return new JdbcTemplate(postgresDataSource());
////	}
////	
////	@Bean(value = "sqliteJdbcTemplate")
////	JdbcTemplate c3P0JdbcTemplate() {
////		return new JdbcTemplate(sqlliteDataSource());
////	}
//	
//}
