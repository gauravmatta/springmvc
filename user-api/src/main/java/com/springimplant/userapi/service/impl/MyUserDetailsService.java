package com.springimplant.userapi.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springimplant.cms.entities.UserPrincipal;
import com.springimplant.userapi.postgres.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = User.builder()
				.username(username)
				.password("password")
				.firstName(username)
				.build();
		return new UserPrincipal(user);
	}
}