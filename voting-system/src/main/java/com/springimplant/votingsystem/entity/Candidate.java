package com.springimplant.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
public class Candidate {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="candidate_name")
	private String name;

	@Column(name="numberOfVotes", columnDefinition = "integer default 0")
	private Integer numberOfVotes;
	
	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
