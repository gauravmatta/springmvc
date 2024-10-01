package com.springimplant.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.taskmanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getUserByName(String name);
}
