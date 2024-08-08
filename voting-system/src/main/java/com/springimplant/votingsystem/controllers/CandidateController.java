package com.springimplant.votingsystem.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.repositories.CandidateRepo;

@RestController
@CacheConfig(cacheNames= "candidates")
public class CandidateController {
	
	public final Logger logger=Logger.getLogger(CandidateController.class);
	
	@Autowired
	CandidateRepo candidateRepo;

	@GetMapping("/candidate/{id}")
	@Cacheable(key = "#id")
	public Candidate getCandidate(@PathVariable Long id) {
		logger.info("Fetching Candidate from DB with id "+id);
		return candidateRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/candidates")
	@ResponseBody
	public List<Candidate> getCandidates() {
		return candidateRepo.findAll();
	}
	
	@PostMapping("/candidate")
	public Candidate createCandidate(@RequestBody Candidate candidate) {
		return candidateRepo.save(candidate);		
	}
	
	@PutMapping("/candidate/{id}")
	@CachePut(key = "#id")
	public Candidate updateCandidate(@RequestBody Candidate candidate,@PathVariable Long id) {
		candidate.setId(id);
		return candidateRepo.save(candidate);
	}
	
	@DeleteMapping("/candidate/{id}")
	@CacheEvict(key = "#id")
	public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
				candidateRepo.deleteById(id);	
				return ResponseEntity.ok().body("Deleted Successfully");
	}
	
}
