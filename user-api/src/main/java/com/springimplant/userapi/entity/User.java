package com.springimplant.userapi.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@IdClass(UserId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
	@Id
	private BigInteger userid;
	@Id
	private BigInteger courseid;
	private String username;
	
	public User() 
	{
		
	}

	public User(int userid, int courseid, String username) {
		this.userid=BigInteger.valueOf(userid);
		this.courseid=BigInteger.valueOf(courseid);
		this.username=username;
	}

	public BigInteger getUserid() {
		return userid;
	}

	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}

	public BigInteger getCourseid() {
		return courseid;
	}

	public void setCourseid(BigInteger courseid) {
		this.courseid = courseid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}