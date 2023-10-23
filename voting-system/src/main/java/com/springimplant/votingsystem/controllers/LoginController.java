package com.springimplant.votingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springimplant.votingsystem.entity.Candidate;
import com.springimplant.votingsystem.entity.User;
import com.springimplant.votingsystem.repositories.CandidateRepo;
import com.springimplant.votingsystem.repositories.UserRepo;

@Controller
@RequestMapping("/admin")
public class LoginController {

	public final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CandidateRepo candidaterepo;
	
//	@Autowired
//	Utils utils;
	
	@RequestMapping("/")
	public String login()
	{
		logger.info("Admin Login");
		return "login.html";
	}
	
	@PostMapping("/")
	public String login(@RequestParam String login,@RequestParam String password,Model model,HttpSession session)
	{
		User u= userRepo.findByUsername(login);
		if(u!=null)
		{
//			String encodedPassword=utils.md5Java(password);
			String givenPassword=u.getPassword();
//			logger.info(encodedPassword+"==>"+givenPassword);
//			if(encodedPassword.equals(givenPassword))
//			{
//				session.setAttribute("user",u);
//				logger.info("Password Match for "+u.getUsername());
//				List<Candidate> clist=candidaterepo.findAll();
//				model.addAttribute("candidateList",clist);
//				return "results.html";
//			}
		}
		else
		{
			model.addAttribute("msg","User Not Found");
			return "login.html";
		}
		return "login.html";
	}
}
