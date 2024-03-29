package com.springimplant.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.jwt.api.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String roleName);
}
