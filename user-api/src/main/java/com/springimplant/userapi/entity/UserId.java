package com.springimplant.userapi.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class UserId implements Serializable
{
	private static final long serialVersionUID = -432332417926431247L;
	private BigInteger userid;
	private BigInteger courseid;
	
	public BigInteger getUserid() 
	{
		return userid;
	}
	public void setUserid(BigInteger userid) 
	{
		this.userid = userid;
	}
	public BigInteger getCourseid() 
	{
		return courseid;
	}
	public void setCourseid(BigInteger courseid) 
	{
		this.courseid = courseid;
	}
}
