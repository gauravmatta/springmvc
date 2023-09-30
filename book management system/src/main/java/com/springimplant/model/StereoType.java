package com.springimplant.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stereo")
@Scope("prototype")
public class StereoType {
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
}
