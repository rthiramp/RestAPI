package com.evry.rentamovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evry.rentamovie.beans.RentedMovies;
import com.evry.rentamovie.service.RentService;

@RequestMapping("/studio")
@RestController
public class RentController {

	@Autowired
	private RentService rentService;
	
	@GetMapping("/v1/rentedmovies")
	public ResponseEntity<List<RentedMovies>> getAllRentedMovies(
			@RequestHeader(name = "Authorization", required = true) String token) {

		return new ResponseEntity<>(rentService.getAllRentedMovies(), HttpStatus.OK);

	}
	
	@GetMapping("/v1/rentedmovies/{id}")
	public ResponseEntity<RentedMovies> getRentedMovieById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("id") long id) {

		return new ResponseEntity<>(rentService.getRentedMovieById(id), HttpStatus.OK);

	}
	
	@GetMapping("/v1/rentedmovies/moviename/{name}")
	public ResponseEntity<List<RentedMovies>> getRentedMovieByMovieName(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("name") String name) {

		return new ResponseEntity<>(rentService.getAllRentedMoviesByMovieName(name), HttpStatus.OK);

	}
	
	@GetMapping("/v1/rentedmovies/cutomername/{name}")
	public ResponseEntity<List<RentedMovies>> getRentedMovieByCustomerName(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("name") String name) {

		return new ResponseEntity<>(rentService.getAllRentedMoviesByCustomerName(name), HttpStatus.OK);

	}
	
	@GetMapping("/v1/rentedmovies/notreturnedyet")
	public ResponseEntity<List<RentedMovies>> getRentedMoviesNotReturnedYet(
			@RequestHeader(name = "Authorization", required = true) String token) {

		return new ResponseEntity<>(rentService.getAllRentedMoviesNotReturnedYet(), HttpStatus.OK);

	}
	
}
