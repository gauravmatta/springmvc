package com.springimplant.jwt.api.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springimplant.jwt.api.dto.UserDto;
import com.springimplant.jwt.api.entity.Authority;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.projections.UserProjection;
import com.springimplant.jwt.api.repository.AuthorityRepository;
import com.springimplant.jwt.api.repository.UserRepository;
import com.springimplant.jwt.api.service.CustomUserDetailService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailServiceImpl implements UserDetailsService,CustomUserDetailService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
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

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}

	@Override
	public List<UserDto> getUsersByRole(String role) {
	log.info("Role Recieved in Service is :" + role);
	List<UserProjection> upj = repository.findUserByRoleName(role);
	log.info("User Project Array : " + upj);
	List<UserDto> users = repository.findUserByRoleName(role).stream().map(user -> modelMapper.map(user, UserDto.class))
			.collect(Collectors.toList());
	log.info("Users are: "+ users);
	return users;
	}

	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public List<UserDto> getUsersByRole() {
		List<UserProjection> upj = repository.findUserByRoleName();
		log.info("Second User Project Array : " + upj);
		List<UserDto> users = repository.findUserByRoleName().stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		log.info("Second Users are: "+ users);
		return users;
	}
	

}
