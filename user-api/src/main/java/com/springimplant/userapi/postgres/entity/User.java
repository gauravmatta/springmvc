package com.springimplant.userapi.postgres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.springimplant.userapi.contracts.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 2948734177737259472L;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "about")
	private String about;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private String enabled;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="roles")
	private String roles;
		
	@Transient
	@Builder.Default
	private List<Rating> ratings = new ArrayList<>();
	
}
