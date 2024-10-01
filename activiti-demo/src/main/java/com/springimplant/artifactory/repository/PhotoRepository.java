package com.springimplant.artifactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springimplant.artifactory.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}