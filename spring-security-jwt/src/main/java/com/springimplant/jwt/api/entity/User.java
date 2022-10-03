package com.springimplant.jwt.api.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
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

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.netflix.eventbus.filter.AlwaysFalseEventFilter;
import com.springimplant.jwt.api.entity.type.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {
	@Id
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	private Long id;
	
	@Column(name = "status")
	@Convert(converter = UserStatus.UserStatusConverter.class)
	protected UserStatus status = UserStatus.ACTIVE;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name="email", nullable = false, unique = true )
	private String email;
	
	@Column(name = "sso_id", nullable = false,length = 128, unique = true)
	@Length(min = 9,max = 9)
	private String userId;
	
	@Column(name = "blocked")
	private boolean blocked;
	
	@Column(name = "last_login")
	private LocalDateTime lastLoginTime;
	
	@Column(name = "registration_token")
	private String registerationToken;
	
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	private String userName;
	private String password;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(Role::getAuthorities)
				.reduce((authorities, authorities2) ->{
					authorities=Optional.ofNullable(authorities).orElseGet(HashSet::new);
					authorities.addAll(authorities2);
					return authorities;
				}).orElse(Collections.EMPTY_SET);
	}
	
	
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String getUsername() {
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}