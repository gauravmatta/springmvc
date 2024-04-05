package com.springimplant.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.jwt.api.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
