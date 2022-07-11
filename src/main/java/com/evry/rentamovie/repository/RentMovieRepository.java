package com.evry.rentamovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.rentamovie.enity.RentedMoviesEntity;

@Repository
public interface RentMovieRepository extends JpaRepository<RentedMoviesEntity, Long> {

	//List<RentedMoviesEntity> findAll();
	
	RentedMoviesEntity findById(long id);
	
	List<RentedMoviesEntity> findByCustomerEntityRef_name(String name);
	
	List<RentedMoviesEntity> findByMovieEntityRef_name(String name);
	
	List<RentedMoviesEntity> findByReturnDateIsNull();
	
}
