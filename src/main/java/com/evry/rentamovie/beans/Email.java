package com.evry.rentamovie.beans;

import lombok.Data;

@Data
public class Email {

	private long id;
	
	//Primary or Secondary
	private String emailType;
	
	@javax.validation.constraints.Email(message = "email format is not valid")
	private String email;
	
}
