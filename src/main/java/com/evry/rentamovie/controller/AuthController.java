package com.evry.rentamovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.evry.rentamovie.beans.ReqToken;
import com.evry.rentamovie.beans.RequestToken;
import com.evry.rentamovie.beans.ResponseToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Auth Controller", value = "Auth Controller")
public class AuthController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ApiOperation(value = "Generate Token")
	@PostMapping("/v1/auth")
	public ResponseEntity<ResponseToken> generateToken(@RequestBody RequestToken requestToken) {
		
		ResponseEntity<ResponseToken> responseToken = restTemplate.postForEntity("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDDX6cg0lC1wDZN440eYmJxSPbGmIvwMQU", new ReqToken(), ResponseToken.class);
		
		return responseToken;

	}

}
