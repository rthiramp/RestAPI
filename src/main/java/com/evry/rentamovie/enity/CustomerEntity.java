package com.evry.rentamovie.enity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS")
@Data
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMERS_ID_GENERATOR", sequenceName="CUSTOMERS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMERS_ID_GENERATOR")
	//@Column(name = "ID")
	private long id;

	@Column(insertable = false)
	private BigDecimal active = BigDecimal.ONE;

	private BigDecimal mob;

	private String name;
	

	@Column(name = "created_at", updatable = false)
	private Timestamp createtAt;
	
	@Column(name = "created_by", updatable = false)
	private String createtBy;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@Column(name = "updated_by")
	private String updatedBy;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="customerEntityRef", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AddressEntity> addresses;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="customerEntityRef", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmailEntity> emails;

	//bi-directional many-to-one association to RentedMovy
	@OneToMany(mappedBy="customerEntityRef")
	private List<RentedMoviesEntity> rentedMovies;


}