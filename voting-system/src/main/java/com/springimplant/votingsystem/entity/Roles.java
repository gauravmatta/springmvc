package com.springimplant.votingsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Roles {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	
	@Column(name="roleName")
	private String roleName;
	
	@ManyToMany(targetEntity=User.class)
	private Set teacherSet;

	public Long getId() {
		return id;
	}

	public Roles() {
		super();
	}

	public Roles(Long id, String roleName, Set teacherSet) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.teacherSet = teacherSet;
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

	public Set getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(Set teacherSet) {
		this.teacherSet = teacherSet;
	}
}
