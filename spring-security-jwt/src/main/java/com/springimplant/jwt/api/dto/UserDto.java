package com.springimplant.jwt.api.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.springimplant.jwt.api.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Set<Role> roles = new HashSet<>();
	private Collection<? extends GrantedAuthority> authorities;
}
