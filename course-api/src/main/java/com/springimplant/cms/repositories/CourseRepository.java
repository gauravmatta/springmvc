package com.springimplant.cms.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.cms.entities.Course;

public interface CourseRepository extends JpaRepository<Course,BigInteger> {

}