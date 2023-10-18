package com.springmvcimplant.ioc.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
private String name;
private Long id;
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dob;
private List<String> course;
private String gender;
private String studenttype;
}
