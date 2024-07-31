package com.springimplant.votingsystem.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.entity.Roles;
import com.springimplant.votingsystem.entity.User;
import com.springimplant.votingsystem.repositories.CandidateRepo;
import com.springimplant.votingsystem.repositories.CitizenRepo;
import com.springimplant.votingsystem.repositories.RoleRepo;
import com.springimplant.votingsystem.repositories.UserRepo;

@RestController
public class IndexController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	RoleRepo rolerepo;
	
	@Autowired
	UserRepo userRepo;

	@PostMapping("/doAction")
	public String doAction()
	{
		Citizen c1=new Citizen(1L,"Gaurav");
		citizenRepo.save(c1);
		Citizen c2=new Citizen(2L,"Manu");
		citizenRepo.save(c2);
		Candidate cd1=new Candidate("AAP");
		Candidate cd2=new Candidate("BJP");
		Candidate cd3=new Candidate("Congress");
		Candidate cd4=new Candidate("NOTA");
		candidateRepo.save(cd1);
		candidateRepo.save(cd2);
		candidateRepo.save(cd3);
		candidateRepo.save(cd4);
		Roles r1=new Roles(1L,"Admin");
		rolerepo.save(r1);
		Set<Roles> hashSet = new HashSet<>();
		hashSet.add(r1);
		User u1=new User(1L,"Gaurav","admin",hashSet);
		userRepo.save(u1);
		return "Success";
	}
}
