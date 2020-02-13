package com.springimplant.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="candidates")
public class Candidate {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="candidate_name")
	private String name;

	@Column(name="numberOfVotes", columnDefinition = "integer default 0")
	private Integer numberOfVotes; 
	
	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidate() {
		super();
	}

	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
