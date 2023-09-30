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
import com.springimplant.model.StereoType;
import com.springimplant.model.Student;
import com.springimplant.model.Subject;
import com.springimplant.model.Teacher;
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
			System.out.println("Hashcode of Student s1 "+s1.hashCode());
			logger.info("Class of S1 Week Attedence: "+s1.getWeekAttendence().getClass().getName());
			logger.info(s2.toString());
			System.out.println("Hashcode of Student s2 "+s2.hashCode());
			logger.info("Class of S2 Week Attedence: "+s2.getWeekAttendence().getClass().getName());
			logger.info(s2.getFavorites().getSubjectName());
			logger.info(sp.toString());
			System.out.println("Hashcode of Student sp "+sp.hashCode());
			logger.info(s3.toString());
			logger.info("Class of S3 Week Attedence: "+s3.getWeekAttendence().getClass().getName());
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
			Subject sub2 = context.getBean("Subject2",Subject.class);
			logger.info(sub2.toString());
			Student s4 = context.getBean("Student4",Student.class);
			logger.info(s4.toString());
			Subject sub4 = context.getBean("Subject4",Subject.class);
			logger.info(sub4.toString());
			Student s5 = context.getBean("Student5",Student.class);
			logger.info(s5.toString());
			Teacher t1= context.getBean("Teach1",Teacher.class);
			logger.info(t1.toString());
			context.registerShutdownHook();
		}
		System.out.println("==================================================");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/springimplant/xml/stereoconfig.xml")) {
			context.registerShutdownHook();
			Student s6 = context.getBean("stu",Student.class);
			System.out.println("Hashcode of Student s6 "+s6.hashCode());
			logger.info(s6.toString());
			Student s7 = context.getBean("stu",Student.class);
			System.out.println("Hashcode of Student s7 "+s7.hashCode());
			StereoType st1 = context.getBean("stereo",StereoType.class);
			System.out.println("Hashcode of Stereo Bean st1 "+st1.hashCode());
			StereoType st2 = context.getBean("stereo",StereoType.class);
			System.out.println("Hashcode of Stereo Bean st2 "+st2.hashCode());
			StereoType st3 = context.getBean("stereo1",StereoType.class);
			System.out.println("Hashcode of Stereo Bean st3 "+st3.hashCode());
			StereoType st4 = context.getBean("stereo1",StereoType.class);
			System.out.println("Hashcode of Stereo Bean st4 "+st4.hashCode());
		}
	}
}
