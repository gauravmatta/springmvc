package com.springimplant.jwt.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.springimplant.jwt.api.entity.type.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {

	@Id
	@SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roles_seq")
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "weight")
	private Long weight;
	
	public Role(Long id) {
		super();
		this.id = id;
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	@ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
	@JoinTable(name = "role_authority",
	joinColumns = @JoinColumn(name="role_id"),
	inverseJoinColumns = @JoinColumn(name= "authority_id"))
	private Set<Authority> authorities = new HashSet<>();
	
	@Column(name="user_type")
	@Convert(converter = UserType.UserTypeConverter.class)
	private UserType userType;
}
