package com.springmvc.bms.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.bms.beans.Student;
import com.springmvc.bms.beans.Subject;
import com.springmvc.bms.configuration.HelloWorldConfiguration;
import com.springmvc.bms.dao.StudentDao;



public class Project {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			Student s1 = context.getBean("stu",Student.class);
			System.out.println(s1.toString());
			Subject sub = context.getBean("subject",Subject.class);
			System.out.println(sub.toString());
			JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
			String query = "insert into student(id,studentName,streetAddress) values(?,?,?)";
			int result = template.update(query,2,"Janmeet","Jalandhar");
			System.out.println("Number of Record Inserted: "+ result);
			StudentDao studentDao = context.getBean("StudentDaoImpl",StudentDao.class);
			Student student = new Student();
			student.setStudentId(3);
			student.setStudentName("Mukesh");
			student.setStreetAddress("Mumbai");
			int sresult = studentDao.insert(student);
			System.out.println("Student Added "+sresult);
			Student student1 = new Student();
			student1.setStudentId(2);
			student1.setStudentName("Manmeet");
			student1.setStreetAddress("Punjab");
			int sresult1 = studentDao.update(student1);
			System.out.println("Student Updated "+sresult1);
			int sresult2 = studentDao.delete(3);
			System.out.println("Student Deleted "+sresult2);
			int sresult3 = studentDao.deleteDuplicates();
			System.out.println("Duplicates Deleted "+sresult3);
			Student student4 = studentDao.getStudent(1);
			System.out.println("Select Result "+student4);
			context.close();
		}
	}
}