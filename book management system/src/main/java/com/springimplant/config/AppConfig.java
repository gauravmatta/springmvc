package com.springimplant.config;


import java.lang.System.Logger.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springimplant.model.Book;
import com.springimplant.model.Student;
import com.springimplant.model.Subject;
import com.springimplant.util.Calc;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.springimplant.dao"),
		@ComponentScan("com.springimplant.service")
})
public class AppConfig {
	
	private static final Logger logger = Logger.getLogger(AppConfig.class.getName());
	
	public static void main(String[] args) {
		logger.info("Hello Main World!");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/config.xml")) {
			Student s1 = (Student) context.getBean("Student1");
			Student s2 = (Student) context.getBean("Student2");
			Student sp = (Student) context.getBean("Studentp");
			Student s3 = (Student) context.getBean("Student3");
			Subject sub1 = (Subject) context.getBean("Subject1");
			logger.info(s1.toString());
			logger.info(s1.toString());
			logger.info(s2.toString());
			logger.info(s2.getFavorites().getSubjectName());
			logger.info(sp.toString());
			logger.info(s3.toString());
			logger.info("Subjects===========>");
			logger.info(sub1.toString());
			Calc c1 = (Calc) context.getBean("Cal1");
			c1.doSum();
			Calc ci = (Calc) context.getBean("Cali");
			ci.doSum();
			Calc cl = (Calc) context.getBean("Call");
			cl.doSum();
			Book b4 = (Book) context.getBean("Book4");
			logger.info(b4.toString());
			Subject sub2 = (Subject) context.getBean("Subject2");
			logger.info(sub2.toString());
			context.registerShutdownHook();
		}
	}
}
