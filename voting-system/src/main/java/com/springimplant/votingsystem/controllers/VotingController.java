package com.springimplant.votingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.repositories.CandidateRepo;
import com.springimplant.votingsystem.repositories.CitizenRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@CacheConfig(cacheNames= "candidates")
public class VotingController {
	
	public final Logger logger=Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	private static final String CITIZEN = "citizen";  
	
	@GetMapping("/")
	public String goToVote()
	{
		logger.info("Voting Started");
		return "vote.html";
	}
	
	@GetMapping("/candidates")
	@ResponseBody
	public List<Candidate> getCandidates() {
		return candidateRepo.findAll();
	}
	
	@GetMapping("/candidate/{id}")
	@ResponseBody
	@Cacheable(key = "#id")
	public Candidate getCandidate(@PathVariable Long id) {
		logger.info("Fetching Candidate from DB with id "+id);
		return candidateRepo.findById(id).orElse(null);
	}
	
	@PostMapping("/casteVote")
	public String casteVote(@RequestParam String name,Model model,HttpSession session)
	{
		Citizen citizen=citizenRepo.findByName(name);
		session.setAttribute(CITIZEN,citizen);
		logger.info(citizen.getName()+" is about to caste vote");
		if(!citizen.isHasVoted())
		{
			List<Candidate> candidates=candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			model.addAttribute(CITIZEN,citizen);
			return "performVote.html";
		}
		else
		{
			return "hasVoted.html";
		}
	}
	
	@GetMapping("/voteFor")
	public String voteFor(@RequestParam Long id,@RequestParam Long ctid,HttpSession session)
	{
		Citizen ctzn=(Citizen)session.getAttribute(CITIZEN);
		
		if(!ctzn.isHasVoted())
		{
			Candidate c= candidateRepo.findById(id).orElse(null);
			if(c!=null) {
			c.setNumberOfVotes(c.getNumberOfVotes()+1);
			c.setDetails(c.getDetails());
			candidateRepo.save(c);
			ctzn.setHasVoted(true);
			citizenRepo.save(ctzn);
			}
			return "voted.html";
		}
		return "hasVoted.html";
	}
}

