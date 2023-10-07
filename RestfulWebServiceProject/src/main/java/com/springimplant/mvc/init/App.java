package com.springimplant.mvc.init;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springimplant.mvc.config.ProjectConfiguration;
import com.springimplant.mvc.dao.StudentDao;
import com.springimplant.mvc.model.Student;


public class App {

	private static final Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class)) {
			StudentDao sdao = context.getBean("studentDao",StudentDao.class);
			Student student = new Student(1,"Gaurav Matta","Delhi");
			int i = sdao.insert(student);
			logger.info("Inserted "+ i);
		}
	}

}
