package com.springimplant.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.votingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> 
{
	public User findByUsername(String name);
}