package com.springimplant.userapi.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.userapi.entity.User;
import com.springimplant.userapi.entity.UserId;
public interface UserRepository extends JpaRepository<User,UserId> {
	
	List<User> findByuserid(BigInteger integer);
	List<User> findBycourseid(BigInteger integer);
}
