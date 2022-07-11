package com.evry.rentamovie.service.impl;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.evry.rentamovie.beans.Movie;
import com.evry.rentamovie.beans.RentedMovies;
import com.evry.rentamovie.enity.RentedMoviesEntity;
import com.evry.rentamovie.repository.RentMovieRepository;
import com.evry.rentamovie.service.RentService;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	private RentMovieRepository rentMovieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<RentedMovies> getAllRentedMovies() {
		List<RentedMoviesEntity> rentedMoviesEntityList = rentMovieRepository.findAll(); 
		if (!CollectionUtils.isEmpty(rentedMoviesEntityList)) {
			Type rentedMoviesListType = new TypeToken<List<RentedMovies>>(){}.getType();
			return modelMapper.map(rentedMoviesEntityList, rentedMoviesListType);
		}
		return Collections.emptyList();
	}

	@Override
	public List<RentedMovies> getAllRentedMoviesByCustomerName(String name) {
		List<RentedMoviesEntity> rentedMoviesEntityList = rentMovieRepository.findByCustomerEntityRef_name(name); 
		if (!CollectionUtils.isEmpty(rentedMoviesEntityList)) {
			Type rentedMoviesListType = new TypeToken<List<RentedMovies>>(){}.getType();
			return modelMapper.map(rentedMoviesEntityList, rentedMoviesListType);
		}
		return Collections.emptyList();
	}

	@Override
	public Movie rentMovie(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie returnMovie(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RentedMovies getRentedMovieById(long id) {
		RentedMoviesEntity rentedMoviesEntity = rentMovieRepository.findById(id);
		if (rentedMoviesEntity != null) {
			return modelMapper.map(rentedMoviesEntity, RentedMovies.class);
		}
		return null;
	}

	@Override
	public List<RentedMovies> getAllRentedMoviesByMovieName(String name) {
		List<RentedMoviesEntity> rentedMoviesEntityList = rentMovieRepository.findByMovieEntityRef_name(name); 
		if (!CollectionUtils.isEmpty(rentedMoviesEntityList)) {
			Type rentedMoviesListType = new TypeToken<List<RentedMovies>>(){}.getType();
			return modelMapper.map(rentedMoviesEntityList, rentedMoviesListType);
		}
		return Collections.emptyList();
	}

	@Override
	public List<RentedMovies> getAllRentedMoviesNotReturnedYet() {
		List<RentedMoviesEntity> rentedMoviesEntityList = rentMovieRepository.findByReturnDateIsNull(); 
		if (!CollectionUtils.isEmpty(rentedMoviesEntityList)) {
			Type rentedMoviesListType = new TypeToken<List<RentedMovies>>(){}.getType();
			return modelMapper.map(rentedMoviesEntityList, rentedMoviesListType);
		}
		return Collections.emptyList();
	}

}
