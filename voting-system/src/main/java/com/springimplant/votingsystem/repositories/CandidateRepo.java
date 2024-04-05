package com.springimplant.votingsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.votingsystem.entity.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate,Long> {
	public Optional<Candidate> findById(Long id);
}
