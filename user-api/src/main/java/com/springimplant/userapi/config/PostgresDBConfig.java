package com.springimplant.userapi.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
		basePackages = {"com.springimplant.userapi.postgres.repository"},
		transactionManagerRef = "postgresTransactionManager"
		)
public class PostgresDBConfig {
	
 	@Bean(name="postgresDataSource")
    @ConfigurationProperties("spring.datasource.postgres")
    DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }
  	
  	@Bean(name = "postgresEntityManagerFactoryBean")
  	@Primary
  	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
  		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
  		bean.setDataSource(postgresDataSource());
  		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
  		bean.setJpaVendorAdapter(adapter);
  		bean.setPackagesToScan("com.springimplant.userapi.postgres.entity");
  		Map<String, String> props = new HashMap<>();
  		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
  		props.put("hibernate.show_sql","true");
  		props.put("hibernate.hbm2ddl.auto","update");
  		bean.setJpaPropertyMap(props);
  		return bean;
  	}
  	
  	@Primary
  	@Bean(name = "postgresTransactionManager")
  	PlatformTransactionManager transactionManager() {
  		JpaTransactionManager manager=new JpaTransactionManager();
  		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
  		return manager;
  	}
}
