package com.springimplant.cms.entities;

public class Course {

private String courseId;
private String courseName;
private String authorName;

public Course(String courseId, String courseName, String authorName) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.authorName = authorName;
}

public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

}
