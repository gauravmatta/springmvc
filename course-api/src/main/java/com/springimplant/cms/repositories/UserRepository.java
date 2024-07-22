package com.springimplant.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.cms.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
