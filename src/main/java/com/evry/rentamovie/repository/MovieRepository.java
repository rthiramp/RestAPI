package com.evry.rentamovie.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.rentamovie.enity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

	Page<MovieEntity> findAll(Pageable pageable);
	
	//List<MovieEntity> findAll();
	
	MovieEntity findById(long id);
	
	List<MovieEntity> findByName(String name);
	
	//List<MovieEntity> findByChargePerDayGreaterThanEqual(BigDecimal chargePerDay, Pageable pageable);
	
	//List<MovieEntity> findByChargePerDayLessThanEqual(BigDecimal chargePerDay, Pageable pageable);
	
	Page<MovieEntity> findByChargePerDayGreaterThanEqual(BigDecimal chargePerDay, Pageable pageable);
	
	Page<MovieEntity> findByChargePerDayLessThanEqual(BigDecimal chargePerDay, Pageable pageable);
	
}
