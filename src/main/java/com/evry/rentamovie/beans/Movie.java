package com.evry.rentamovie.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Movie {

	private long id;
	@NotBlank(message = "name must not be blank")
	private String name;
	@NotNull(message = "chargePerDay must not be null")
	private BigDecimal chargePerDay;
	@NotNull(message = "availableCount must not be null")
	private BigDecimal availableCount;
	private BigDecimal active = BigDecimal.ONE;
	
	private Timestamp createtAt;
	private String createtBy;
	private Timestamp updatedAt;
	private String updatedBy;
	
}
