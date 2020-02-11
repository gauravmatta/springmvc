package com.springimplant.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.Citizen;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
	
}
