package com.springimplant.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springimplant.cms.entities.User;
import com.springimplant.cms.entities.UserPrincipal;
import com.springimplant.cms.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

}
