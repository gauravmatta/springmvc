package com.springimplant.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("stereo")
@Scope("prototype")
@ToString
public class StereoType {
	@Value("#{ 22+11 }")
	private int id;	
	@Value("Gaurav Matta")
	private String studentName;
	@Value("19c")
	private String streetAddress;
	@Value("#{absentAttendence}")
	private List<String> weekAttendence;
	@Value("#{subjects}")
	private Set<String> subjects;
	@Value("#{alldistinction}")
	private Map<String,String> marks;
	Properties attendenceKeys = new Properties();
	@Value("#{T(java.lang.Math).cbrt(729)}")
	private double cbrt;
	@Value("#{T(java.lang.Math).E}")
	private double e;
	@Value("#{T(java.lang.Math).PI}")
	private double pie;
}
