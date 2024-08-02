package com.springimplant.votingsystem.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class RoleTypeValidator implements ConstraintValidator<ValidateRoleType,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> roleTypes =Arrays.asList("Admin","Citizen","Candidate");
		return roleTypes.contains(value);
	}

}
