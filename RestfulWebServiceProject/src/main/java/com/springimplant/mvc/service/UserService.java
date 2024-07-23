package com.springimplant.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.mvc.dao.UserDao;
import com.springimplant.mvc.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}
}
