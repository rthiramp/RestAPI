package com.evry.rentamovie.enity;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@Data
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_ID_GENERATOR", sequenceName="ADDRESS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ID_GENERATOR")
	//@Column(name = "ID")
	private long id;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	private String building;

	private String city;

	private String doorno;

	@Column(name="FLOOR_NO")
	private String floorNo;

	private BigDecimal postalcode;

	private String street;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private CustomerEntity customerEntityRef;

}