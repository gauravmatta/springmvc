package com.springimplant.jwt.api.service;

import java.util.List;

import com.springimplant.jwt.api.dto.UserDto;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.projections.UserProjection;

public interface CustomUserDetailService {

	List<User> findAllUsers();
	List<UserDto> getUsersByRole(String role);
	List<UserDto> getUsersByRole();
	User createUser(User user);
}
