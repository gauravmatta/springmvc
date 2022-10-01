package com.springimplant.jwt.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springimplant.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUserName(String username);

	Optional<User> findByUserId(String userId);

}
