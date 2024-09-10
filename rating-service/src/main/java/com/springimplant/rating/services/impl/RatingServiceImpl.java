package com.springimplant.rating.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springimplant.rating.entities.Rating;
import com.springimplant.rating.repository.RatingRepository;
import com.springimplant.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository repository;

	@Override
	public Rating create(Rating rating) {
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByOrderId(String orderId) {
		return repository.findByOrderId(orderId);
	}

}
