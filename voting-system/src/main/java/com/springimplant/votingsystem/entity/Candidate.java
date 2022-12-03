package com.springimplant.votingsystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springimplant.votingsystem.entity.converter.CandidateDetailConverter;
import com.springimplant.votingsystem.entity.json.object.CandidateDetail;

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
	
	@Column(name = "details",columnDefinition = "jsonb")
	@Convert(converter = CandidateDetailConverter.class)
	private List<CandidateDetail> details;
	
	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
