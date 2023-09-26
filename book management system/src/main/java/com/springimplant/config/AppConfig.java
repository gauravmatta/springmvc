package com.springimplant.config;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springimplant.model.Student;
import com.springimplant.model.Subject;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.springimplant.dao"),
		@ComponentScan("com.springimplant.service")
})
public class AppConfig {
	
	private static final Log log = LogFactory.getLog(AppConfig.class);
//	private static final boolean isDebugging = log.isDebugEnabled();
	
	public static void main(String[] args) {
		log.info("Hello Main World!");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/config.xml")) {
			Student s1 = (Student) context.getBean("Student1");
			Student s2 = (Student) context.getBean("Student2");
			Student sp = (Student) context.getBean("Studentp");
			Subject su1 = (Subject) context.getBean("Subject1");
			log.info(s1.toString());
			System.out.println(s1.toString());
			System.out.println(s2.toString());
			System.out.println(s2.getFavorites().getSubjectName());
			System.out.println(sp.toString());
			System.out.println("Subjects===========>");
			System.out.println(su1.toString());
		}
	}
}
