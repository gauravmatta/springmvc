package com.springimplant.votingsystem.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RoleTypeValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateRoleType {
	public String message() default "Invalid roleType: It shpuld be either Admin,Candidate or Citizen";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}