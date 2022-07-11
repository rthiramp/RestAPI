package com.evry.rentamovie.enity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


/**
 * The persistent class for the RENTED_MOVIES database table.
 * 
 */
@Entity
@Table(name="RENTED_MOVIES")
@Data
public class RentedMoviesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RENTED_MOVIE_ID_GENERATOR", sequenceName="RENTAMOVIE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RENTED_MOVIE_ID_GENERATOR")
	//@Column(name = "ID")
	private long id;

	@Column(name="RENT_AMOUNT")
	private BigDecimal rentAmount;

	@Column(name="RENT_DATE")
	private Timestamp rentDate;

	@Column(name="RETURN_DATE")
	private Timestamp returnDate;

////	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	@JsonIgnore
	private CustomerEntity customerEntityRef;
//
//	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	@JsonIgnore
	private MovieEntity movieEntityRef;

}