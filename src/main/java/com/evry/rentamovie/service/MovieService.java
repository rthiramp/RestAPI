package com.evry.rentamovie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.evry.rentamovie.beans.Movie;
import com.evry.rentamovie.util.ListPage;

@Service
public interface MovieService {

	ListPage getAllMovies(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
	Movie getMovieById(long id);
	
	Movie addMovie(Movie movie);
	
	Movie updateMovie(Movie movie);

	void deleteMovieById(long id);
	
	List<Movie> getMovieByName(String name);
	
	ListPage getMoviesGreaterThanOrEqual(BigDecimal chargePerDay, Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
	ListPage getMoviesLessThanOrEqual(BigDecimal chargePerDay, Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
}
