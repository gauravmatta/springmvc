package com.springimplant.userapi.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.userapi.postgres.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}