package com.springimplant.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String email;
private String username;
private String password;

}
