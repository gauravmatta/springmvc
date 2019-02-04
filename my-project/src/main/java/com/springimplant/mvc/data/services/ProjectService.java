package com.springimplant.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.springimplant.mvc.data.entities.Project;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();
	
	public ProjectService(){
		Project p1 = this.createProject("Project 1", "This is description for Project 1" );
		Project p2 = this.createProject("Project 2", "This is overview of Project 2");
		Project p3 = this.createProject("Project 3", "This explains Project 3");
		this.projects.addAll(Arrays.asList(new Project[]{p1,p2,p3}));
	}
	
	public List<Project> findAll(){
		return this.projects;
	}
	
//	public Project find(Long projectId){
//		return this.projects.stream().filter(p -> {
//			return p.getProjectId().equals(projectId);
//		}).collect(Collectors.toList()).get(0);
//	}

	private Project createProject(String title, String description) {
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setSponser("Spring MVC Implant");
		project.setProjectId(1L);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);
		return project;
	}
		
}