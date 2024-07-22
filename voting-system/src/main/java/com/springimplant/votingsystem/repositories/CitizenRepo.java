package com.springimplant.votingsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.votingsystem.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Long> {
	public Citizen findByName(String name);
	public Optional<Citizen> findById(Long id);
}
