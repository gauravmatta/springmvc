package com.springimplant.userapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.userapi.exceptions.ResourseNotFoundException;
import com.springimplant.userapi.postgres.entity.User;
import com.springimplant.userapi.postgres.repository.UsersRepository;
import com.springimplant.userapi.service.PostgresUserService;

@Service
public class PostgresUserServiceImpl implements PostgresUserService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public User saveUser(User user) {
		return usersRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return usersRepository.findAll();
	}

	@Override
	public User getUser(Long userId) {
		return usersRepository.findById(userId).orElseThrow(
				() -> new ResourseNotFoundException("User with given Id is not found on server !! : " + userId));
	}

}