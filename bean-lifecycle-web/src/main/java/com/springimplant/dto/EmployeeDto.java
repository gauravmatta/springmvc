package com.springimplant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class EmployeeDto {

	public int EID;
	public String Names;
	public long Salary;
}
