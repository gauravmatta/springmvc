package com.springimplant.mvc.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
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
			List<Student> students = sdao.getAllStudents();
			if(students.isEmpty()) {
				Student student = new Student(1,"Gaurav Matta","Delhi");
				int i = sdao.insert(student);
				logger.info("Inserted Demo Student "+ i);
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			boolean go = true;
			while(go) {
			System.out.println("Press 1 to add new student");
			System.out.println("Press 2 to display all students");
			System.out.println("Press 3 to get detail of single student");
			System.out.println("Press 4 to delete student");
			System.out.println("Press 5 to update student");
			System.out.println("Press 6 to exit");
			
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// add new Student
					break;
				case 2:
					// display all
					break;
				case 3:
					// display single
					break;
				case 4:
//					delete student
					break;
				case 5:
//					update student
					break;
				case 6:
					go = false;
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}
			}
			System.out.println("Thank you for using application");
			System.out.println("See you Soon!");
		}
	}

}
