package com.springimplant.taskmanager.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {
	@Id
	@GenericGenerator(name="inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	@Column(name="Id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="UserTasks", joinColumns = @JoinColumn(name="id"))
	@Column(name="tasks")
	private List<String> tasks;
	
}
