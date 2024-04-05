package com.springimplant.jwt.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authorties")
public class Authority implements GrantedAuthority{

//	private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	@SequenceGenerator(name = "authorties_seq", sequenceName = "authorties_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authorties_seq")
	private Long id;
	
	@Column(name="authority")
	private String authority;
	
	@Column(name="description")
	private String description;
	
	@Override
	public String getAuthority() {
		return authority;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Authority) {
			return this.authority.equals(((Authority) obj).authority);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.authority.hashCode();
	}

	@Override
	public String toString() {
		return this.authority;
	}
	
	
}
