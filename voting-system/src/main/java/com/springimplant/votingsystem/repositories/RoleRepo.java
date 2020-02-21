package com.springimplant.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.votingsystem.entity.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles,Integer> {

}
