package com.springimplant.complaintsystem.entities;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@Column(name = "id")
	@GenericGenerator(name = "inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
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

	public Complaint(String message, String senderName, String senderEmail) {
		super();
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
