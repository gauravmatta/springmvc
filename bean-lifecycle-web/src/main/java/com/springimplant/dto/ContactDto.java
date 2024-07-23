package com.springimplant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDto {
	private Integer id;
	private String name;
	private String email;
	private String address;
}
