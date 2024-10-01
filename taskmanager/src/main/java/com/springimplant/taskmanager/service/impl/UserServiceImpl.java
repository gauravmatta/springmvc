package com.springimplant.taskmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.taskmanager.entity.User;
import com.springimplant.taskmanager.repository.UserRepository;
import com.springimplant.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	
	@Override
	public boolean register(User user) {
		if(user.getName().isEmpty() || user.getPassword().isEmpty()) {
			return false;
		}
		User existingUser = userRepository.getUserByName(user.getName());
		if(existingUser != null) {
			return false;
		}
		save(user);
		return true;
	}

	@Override
	public User getUser(String name) {
		return userRepository.getUserByName(name);
	}

}
