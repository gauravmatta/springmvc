package com.springimplant.votingsystem.repositories;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> 
{
	public User findByUsername(String name);
}