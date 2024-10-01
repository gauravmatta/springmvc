package com.springimplant.userapi.sqllite.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.userapi.sqllite.entity.User;
import com.springimplant.userapi.sqllite.entity.UserId;


public interface UserRepository extends JpaRepository<User,UserId> {
	List<User> findByuserid(BigInteger integer);
	List<User> findBycourseid(BigInteger integer);
}
