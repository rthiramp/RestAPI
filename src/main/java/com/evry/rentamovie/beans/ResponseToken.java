package com.evry.rentamovie.beans;

import lombok.Data;

@Data
public class ResponseToken {

	private String kind;

	private String localId;

	private String email;

	private String displayName;

	private String idToken;

	private String registered;

	private String refreshToken;

	private String expiresIn;

}
