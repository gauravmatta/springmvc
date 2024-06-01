package com.springimplant.complaintmanager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info (
		title = "Complaint Manager API",
		description = "Doing CRUD Operation",
		summary = "This complaint api will add,delete,create and update",
		termsOfService = "T&C",
		contact = @Contact(
				name = "Spring Implant",
				email = "gaurav.matta.tech@gmail.com"
				),
		license = @License(
				name = "Your License No"
				),
		version = "v1"
	)
)
public class OpenApiConfig {

}
