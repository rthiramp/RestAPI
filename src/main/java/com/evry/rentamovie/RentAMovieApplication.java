package com.evry.rentamovie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class RentAMovieApplication {


	public static void main(String[] args) {
		SpringApplication.run(RentAMovieApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
	  return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
