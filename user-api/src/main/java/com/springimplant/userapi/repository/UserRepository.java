package com.springimplant.userapi.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.userapi.entity.User;
public interface UserRepository extends JpaRepository<User,BigInteger> {
	
	List<User> findByuserid(BigInteger integer);
	List<User> findBycourseid(BigInteger integer);
}
