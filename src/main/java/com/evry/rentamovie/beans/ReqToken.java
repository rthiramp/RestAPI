package com.evry.rentamovie.beans;

import lombok.Data;

@Data
public class ReqToken {

	private String email = "bindu@test.com";

	private String password = "bindu@123";

	private boolean returnSecureToken = true;

}
