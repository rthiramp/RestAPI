package com.evry.rentamovie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evry.rentamovie.beans.Movie;
import com.evry.rentamovie.beans.RentedMovies;

@Service
public interface RentService {

	List<RentedMovies> getAllRentedMovies();
	
	RentedMovies getRentedMovieById(long id);
	
	List<RentedMovies> getAllRentedMoviesByCustomerName(String name);
	
	List<RentedMovies> getAllRentedMoviesByMovieName(String name);
	
	List<RentedMovies> getAllRentedMoviesNotReturnedYet();
	
	Movie rentMovie(long movieId);
	
	Movie returnMovie(long movieId);
	
}
