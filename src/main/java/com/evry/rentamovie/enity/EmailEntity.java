package com.evry.rentamovie.enity;

import java.io.Serializable;

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
 * The persistent class for the EMAILS database table.
 * 
 */
@Entity
@Table(name="EMAILS")
@Data
public class EmailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMAILS_ID_GENERATOR", sequenceName="EMAIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMAILS_ID_GENERATOR")
	//@Column(name = "ID")
	private long id;

	private String email;

	@Column(name="EMAIL_TYPE")
	private String emailType;


	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private CustomerEntity customerEntityRef;


}