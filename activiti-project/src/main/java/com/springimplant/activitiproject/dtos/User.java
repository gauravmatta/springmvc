package com.springimplant.activitiproject.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonRootName("Employee")
public class User {
	private String name;
	private Integer age;
}
