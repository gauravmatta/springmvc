package com.springimplant.jwt.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springimplant.jwt.api.entity.Authority;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.repository.AuthorityRepository;
import com.springimplant.jwt.api.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<User> userObj = repository.findByUserId(username);
	User user = new User();
	if(userObj.isPresent()) {
		user = userObj.get();	
	}
//	List<Authority> allAuthorities = authorityRepository.findAll().stream().collect(Collectors.toList());
	Collection<? extends GrantedAuthority> allAuthorities = user.getAuthorities();
	return new org.springframework.security.core.userdetails.User(user.getUserId(),new BCryptPasswordEncoder().encode(user.getUserId()),allAuthorities);
	}
	

}
