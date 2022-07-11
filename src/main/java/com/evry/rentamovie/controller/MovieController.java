package com.evry.rentamovie.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evry.rentamovie.beans.Movie;
import com.evry.rentamovie.exceptions.DataInvalidException;
import com.evry.rentamovie.service.MovieService;
import com.evry.rentamovie.util.ListPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/studio")
@RestController
@Validated
@Api(tags = "Movie Controller", value = "Movie Controller")
public class MovieController {

	private static final String SUCCCESS_MSG = "SUCCESS";
	
	@Autowired
	private MovieService movieService;
	

	@ApiOperation(value = "List of Movies")
	@GetMapping("/v1/movies")
	public ResponseEntity<ListPage> getAllMovies(
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
	@RequestParam(name = "pageSize", required = false) Integer  pageSize,
	@RequestParam(name = "sortBy", required = false) String sortBy,
	@RequestParam(name = "sortOrder", required = false) String sortOrder) {

		return new ResponseEntity<>(movieService.getAllMovies(pageNo, pageSize, sortBy, sortOrder), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Movie by id")
	@GetMapping("/v1/movies/{id}")
	public ResponseEntity<Movie> getMovieById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("id") long id) {

		return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);

	}
	
	@ApiOperation(value = "List of Movies by names")
	@GetMapping("/v1/movies/name/{name}")
	public ResponseEntity<List<Movie>> getMovieByName(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("name") String name) {
		
		return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);

	}
	
	@ApiOperation(value = "List of Movies greater than equal rent price per day")
	@GetMapping("/v1/movies/greaterthanequal/{chargePerDay}")
	public ResponseEntity<ListPage> getMoviesGreaterThanChargePerDay(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("chargePerDay") BigDecimal chargePerDay,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "pageSize", required = false) Integer  pageSize,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortOrder", required = false) String sortOrder) {
		
		return new ResponseEntity<>(movieService.getMoviesGreaterThanOrEqual(chargePerDay, pageNo, pageSize, sortBy, sortOrder), HttpStatus.OK);

	}
	
	@ApiOperation(value = "List of Movies less than equal rent price per day")
	@GetMapping("/v1/movies/lessthanequal/{chargePerDay}")
	public ResponseEntity<ListPage> getMoviesLessThanChargePerDay(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("chargePerDay") BigDecimal chargePerDay,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "pageSize", required = false) Integer  pageSize,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortOrder", required = false) String sortOrder) {
		
		return new ResponseEntity<>(movieService.getMoviesLessThanOrEqual(chargePerDay, pageNo, pageSize, sortBy, sortOrder), HttpStatus.OK);

	}
	
	@PostMapping("/v1/movies")
	public ResponseEntity<Movie> addMovie(
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody Movie movie) {

		return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);

	}
	
	@PutMapping("/v1/movies/{id}")
	public ResponseEntity<Movie> updateMovie(
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody Movie movie, @PathVariable("id") long id) throws DataInvalidException {
		if (movie.getId() != id) {
			throw new DataInvalidException("Movie id does not match passed in request body and path param");
		}
		return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.OK);

	}
	
	@DeleteMapping("/v1/movies/{id}")
	public ResponseEntity<String> deleteMovieById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("id") long id) {
		movieService.deleteMovieById(id);
		return new ResponseEntity<>(SUCCCESS_MSG, HttpStatus.OK);

	}
	
}
