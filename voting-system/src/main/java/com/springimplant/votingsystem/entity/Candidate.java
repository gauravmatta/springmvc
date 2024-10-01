package com.springimplant.votingsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

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
public class Candidate implements Serializable {

	private static final long serialVersionUID = -4002650768205367766L;

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
	@ColumnTransformer(write = "?::jsonb")
	private List<CandidateDetail> details;
	
	public Candidate(String name) {
		super();
		this.name = name;
		List<CandidateDetail> cdl = new ArrayList<>();
		CandidateDetail cd = new CandidateDetail();
		cd.setAssets("2000");
		cd.setLiabilities("2000");
		cd.setYear("2021");
		cdl.add(cd);
		this.details=cdl;
		this.numberOfVotes=0;
	}
}
