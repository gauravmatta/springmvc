package com.springimplant.userapi.service;

import java.util.List;

import com.springimplant.userapi.postgres.entity.User;

public interface PostgresUserService {

	User saveUser(User user);
	List<User> getAllUser();
	User getUser(Long userId);
	
}
