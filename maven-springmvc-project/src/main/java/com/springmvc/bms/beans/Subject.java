package com.springmvc.bms.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("sub")
public class Subject implements InitializingBean,DisposableBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	private String subjectName;
	private List<Book> books;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Subject "+this.subjectName);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Subject "+this.subjectName);
	}
	
	public Subject(List<Book> books) {
		this.books=books;
	}
}
