package com.evry.rentamovie.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RentedMovies {

	private long id;
	private Movie movie;
	@NotNull(message = "rentDate must not be null")
	private Date rentDate;
	private Date returnDate;
    private BigDecimal rentAmount;
    
}
