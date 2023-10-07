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
					System.out.println("Enter user id:");
					int uid = Integer.parseInt(br.readLine());
					System.out.println("Enter user name:");
					String uName = br.readLine();
					System.out.println("Enter user Address:");
					String address = br.readLine();
					Student stu = sdao.getStudent(uid);
					if(stu != null) {
						throw new Exception("Student id already exists");
					} else {
						Student s = new Student();
						s.setStudentId(uid);
						s.setStudentName(uName);
						s.setStreetAddress(address);
						int id = sdao.insert(s);
						System.out.println("Inserted Student "+ id);
					}
					break;
				case 2:
					students = sdao.getAllStudents();
					students.forEach(s -> System.out.println(s));
					break;
				case 3:
					System.out.println("Enter user id:");
					uid = Integer.parseInt(br.readLine());
					stu =sdao.getStudent(uid);
					if(stu == null) {
						throw new Exception("Student id is Invalid");
					} else {
						System.out.println(stu.toString());
					}
					break;
				case 4:
					System.out.println("Enter user id:");
					uid = Integer.parseInt(br.readLine());
					sdao.deleteStudent(uid);
					break;
				case 5:
					System.out.println("Enter user id:");
					uid = Integer.parseInt(br.readLine()); 
					System.out.println("Enter user name:");
					uName = br.readLine();
					System.out.println("Enter user Address:");
					address = br.readLine();
					stu =sdao.getStudent(uid);
					if(stu == null) {
						throw new Exception("Student id is Invalid");
					} else {
						Student s = new Student();
						s.setStudentId(uid);
						s.setStudentName(uName);
						s.setStreetAddress(address);
						sdao.updateStudent(s);
						System.out.println("Updated Student "+ uid);
					}
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
