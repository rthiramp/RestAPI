package com.evry.rentamovie.beans;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Address {

	private long id;
	private String doorno;
	private String floorNo;
	private String building;
	private String street;
	private String city;
	private BigDecimal postalcode;
	//Residential or Office
	private String addressType;
	
}
