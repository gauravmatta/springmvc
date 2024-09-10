package com.springimplant.rating.services;

import java.util.List;

import com.springimplant.rating.entities.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingByOrderId(String orderId);

}
