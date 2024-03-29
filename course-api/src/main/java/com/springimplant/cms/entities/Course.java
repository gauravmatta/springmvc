package com.springimplant.cms.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {

@Id
private BigInteger courseid;
private String coursename;
private String author;

public Course() {
}

public Course(int id, String name, String author) {
	this.courseid=BigInteger.valueOf(id);
	this.coursename=name;
	this.author=author;
}

public BigInteger getCourseid() {
	return courseid;
}

public void setCourseid(BigInteger courseid) {
	this.courseid = courseid;
}

public String getCoursename() {
	return coursename;
}

public void setCoursename(String coursename) {
	this.coursename = coursename;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

}
