package com.springimplant.userapi.postgres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.userapi.postgres.entity.User;

public interface UsersRepository extends JpaRepository<User, String> {
	
	Optional<User> findByUsername(String username);

}