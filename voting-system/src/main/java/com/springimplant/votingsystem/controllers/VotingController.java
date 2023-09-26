package com.springimplant.votingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
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
	
	public final Logger logger=Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote()
	{
		logger.info("Voting Started");
		return "vote.html";
	}
	
	@RequestMapping("/casteVote")
	public String casteVote(@RequestParam String name,Model model,HttpSession session)
	{
		Citizen citizen=citizenRepo.findByName(name);
		session.setAttribute("citizen",citizen);
		logger.info(citizen.getName()+" is about to caste vote");
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
	public String voteFor(@RequestParam Long id,@RequestParam Long ctid,HttpSession session)
	{
		Citizen ctzn=(Citizen)session.getAttribute("citizen");
		
		if(!ctzn.isHasVoted())
		{
			Candidate c= candidateRepo.findById(id).get();
			c.setNumberOfVotes(c.getNumberOfVotes()+1);
			candidateRepo.save(c);
			ctzn.setHasVoted(true);
			Citizen citizen=citizenRepo.findById(ctid);
			citizen.setHasVoted(true);
			citizenRepo.save(citizen);
			citizenRepo.save(ctzn);
			return "voted.html";
		}
		return "hasVoted.html";
	}
	
}

