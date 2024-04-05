package com.springimplant.taskmanager.service;

import com.springimplant.taskmanager.entity.User;

public interface UserService {
	
	public void save(User user);
	public User getUser(String user);
	boolean register(User user);

}