package com.evry.rentamovie.enity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

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
 * The persistent class for the MOVIES database table.
 * 
 */
@Entity
@Table(name="MOVIES")
@Data
public class MovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIES_ID_GENERATOR", sequenceName="MOVIES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIES_ID_GENERATOR")
	//@Column(name = "ID")
	private long id;

	@Column(insertable = false)
	private BigDecimal active = BigDecimal.ONE;

	@Column(name="AVAILABLE_COUNT")
	private BigDecimal availableCount;

	@Column(name="CHARGE_PER_DAY")
	private BigDecimal chargePerDay;

	private String name;

	//bi-directional many-to-one association to RentedMovy
	@OneToMany(mappedBy="movieEntityRef")
	private List<RentedMoviesEntity> rentedMovies;
	
	@Column(name = "created_at", updatable = false)
	private Timestamp createtAt;
	
	@Column(name = "created_by", updatable = false)
	private String createtBy;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@Column(name = "updated_by")
	private String updatedBy;

}