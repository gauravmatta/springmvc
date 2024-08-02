package com.springimplant.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springimplant.votingsystem.validators.ValidateRoleType;

@Entity(name="roles")
public class Roles {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="roleName")
	@ValidateRoleType
	private String roleName;

	public Long getId() {
		return id;
	}

	public Roles() {
		super();
	}

	public Roles(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	public Roles(String roleName) {
		super();
		this.roleName = roleName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
