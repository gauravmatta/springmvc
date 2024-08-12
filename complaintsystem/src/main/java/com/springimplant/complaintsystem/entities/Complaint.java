package com.springimplant.complaintsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "sender_name")
	private String senderName;
	
	@Column(name = "sender_email")
	private String senderEmail;

	public Complaint() {
		super();
	}

	public Complaint(Integer id, String message, String senderName, String senderEmail) {
		super();
		this.id = id;
		this.message = message;
		this.senderName = senderName;
		this.senderEmail = senderEmail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
}
