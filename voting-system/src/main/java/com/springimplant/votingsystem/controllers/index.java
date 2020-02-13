package com.springimplant.votingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.repositories.CandidateRepo;
import com.springimplant.votingsystem.repositories.CitizenRepo;

@RestController
public class index {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;

	@RequestMapping("/doAction")
	public String doAction()
	{
		Citizen c1=new Citizen(1L,"Gaurav");
		citizenRepo.save(c1);
		Candidate cd1=new Candidate(1L,"AAP");
		Candidate cd2=new Candidate(2L,"BJP");
		Candidate cd3=new Candidate(3L,"Congress");
		Candidate cd4=new Candidate(4L,"NOTA");
		candidateRepo.save(cd1);
		candidateRepo.save(cd2);
		candidateRepo.save(cd3);
		candidateRepo.save(cd4);
		return "Success";
	}
}
