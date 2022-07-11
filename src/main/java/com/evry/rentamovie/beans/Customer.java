package com.evry.rentamovie.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Customer {

	private long id;
	private BigDecimal active = BigDecimal.ONE;
	@NotBlank(message = "name must not be blank")
	private String name;
	@NotNull(message = "mob must not be null")
	private BigDecimal mob;
	@Valid
	private List<Email> emails;
	private List<Address> addresses;
	private List<RentedMovies> rentedMovies;
	
	private Timestamp createtAt;
	private String createtBy;
	private Timestamp updatedAt;
	private String updatedBy;
	
}
