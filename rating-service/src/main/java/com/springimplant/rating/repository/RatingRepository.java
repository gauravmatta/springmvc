package com.springimplant.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springimplant.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByOrderId(String orderId);

}
