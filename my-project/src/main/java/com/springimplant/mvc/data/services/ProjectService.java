package com.springimplant.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.springimplant.mvc.data.entities.Project;
import com.springimplant.mvc.data.entities.Sponsor;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();
	
	public ProjectService(){
		Project p1 = this.createProject(1L,"Project 1", "This is description for Project 1",new Sponsor("S1", "111-111-1111","s1@s1.com"));
		Project p2 = this.createProject(2L,"Project 2", "This is overview of Project 2",new Sponsor("S2", "222-222-2222","s2@s2.com"));
		Project p3 = this.createProject(3L,"Project 3", "This explains Project 3",new Sponsor("S3", "333-333-3333","s3@s3.com"));
		this.projects.addAll(Arrays.asList(new Project[]{p1,p2,p3}));
	}
	
	public List<Project> findAll(){
		return this.projects;
	}
	
	public Project find(Long projectId){
		return this.projects.stream().filter(p -> {
			return p.getProjectId().equals(projectId);
		}).collect(Collectors.toList()).get(0);
	}
	
	public void save(Project project){
		this.projects.add(project);
	}

	private Project createProject(Long projectId,String title, String description,Sponsor sponsor) {
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setSponsor(sponsor);
		project.setProjectId(projectId);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);
		return project;
	}
		
}