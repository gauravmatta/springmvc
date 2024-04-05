package com.springimplant.votingsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.springimplant.votingsystem.util.Utils;

@Entity(name="users")
public class User extends Utils {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(targetEntity=Roles.class)
	private Set roleSet;

	public Long getId() {
		return id;
	}

	public User() {
		super();
	}

	public User(Long id, String username, String password, Set roleSet) {
		super();
		this.id = id;
		this.username = username;
		this.password = md5Java(password);
		this.roleSet = roleSet;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set roleSet) {
		this.roleSet = roleSet;
	}
}
