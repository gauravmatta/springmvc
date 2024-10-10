package com.springimplant.userapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springimplant.cms.entities.UserPrincipal;
import com.springimplant.userapi.postgres.entity.User;
import com.springimplant.userapi.postgres.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		return user.map(UserPrincipal::new).orElseThrow(()-> new UsernameNotFoundException("Not Found : "+ username));
	}
}