package com.springimplant.complaint_manager;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:database-properties.properties"})
@ComponentScan({"com.springimplant.complaint_manager"})
public class PersistanceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverCLassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager TransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transacManager=new HibernateTransactionManager();
		transacManager.setSessionFactory(sessionFactory);
		return transacManager;
	}
	
	@Bean
	LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.springimplant.complaint_manager.entities"});
		sessionFactory.setHibernateProperties(hibernateConfig());
		return sessionFactory;
	}
	
	Properties hibernateConfig()
	{
		Properties configProp=new Properties();
		configProp.setProperty("hibernate.hdm2ddl.auto",env.getProperty("hibernate.hdm2ddl.auto"));
		configProp.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
		configProp.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		return configProp;
	}
}
