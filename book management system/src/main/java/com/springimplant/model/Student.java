package com.springimplant.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int studentId;
	private String studentName;
	private String studentAddress;
	private List<String> weekAttendence;
	private Set<String> subjects;
	private Map<String,String> marks;
	Properties attendenceKeys = new Properties();
}