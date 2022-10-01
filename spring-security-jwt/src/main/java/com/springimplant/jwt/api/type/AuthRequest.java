package com.springimplant.jwt.api.type;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	@Length(min = 5,max = 50)
	private String userName;
	@Length(min = 5,max = 10)
	private String password;
}
