package com.springimplant.votingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.repositories.CandidateRepo;
import com.springimplant.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote()
	{
		return "vote.html";
	}
	
	@RequestMapping("/casteVote")
	public String casteVote(@RequestParam String name,Model model)
	{
		Citizen citizen=citizenRepo.findByName(name);
		if(!citizen.isHasVoted())
		{
			List<Candidate> candidates=candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			model.addAttribute("citizen",citizen);
			return "performVote.html";
		}
		else
		{
			return "hasVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id,@RequestParam Long ctid)
	{
		Candidate c= candidateRepo.findById(id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		Citizen citizen=citizenRepo.findById(ctid);
		citizen.setHasVoted(true);
		citizenRepo.save(citizen);
		return "voted.html";
	}
	
}
