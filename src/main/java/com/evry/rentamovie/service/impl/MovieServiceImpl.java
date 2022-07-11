package com.evry.rentamovie.service.impl;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.evry.rentamovie.beans.Movie;
import com.evry.rentamovie.enity.MovieEntity;
import com.evry.rentamovie.repository.MovieRepository;
import com.evry.rentamovie.service.MovieService;
import com.evry.rentamovie.util.ListPage;
import com.evry.rentamovie.util.Util;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ListPage getAllMovies(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable pageable = Util.getPageable(pageNo, pageSize, sortBy, sortOrder);
		Page<MovieEntity> movieEntityList = movieRepository.findAll(pageable); 
		if (movieEntityList != null && movieEntityList.getSize() > 0) {
			Type movieListType = new TypeToken<List<Movie>>(){}.getType();
			List<MovieEntity> fectedMovieList = modelMapper.map(movieEntityList.getContent(), movieListType);
			ListPage listPage = new ListPage();
			listPage.setList(fectedMovieList);
			listPage.setTotal(fectedMovieList.size());
			listPage.setStartIndex(pageNo);
			listPage.setEndIndex(pageSize);
			listPage.setSortBy(sortBy);
			listPage.setSortOrder(sortOrder);
			return listPage;
		}
		return new ListPage();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Movie addMovie(Movie movie) {
		movie.setCreatetAt(new Timestamp(new Date().getTime()));
		movie.setCreatetBy("superuser");
		MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
		movieEntity = movieRepository.saveAndFlush(movieEntity);
		Movie savedMovieRecord = modelMapper.map(movieEntity, Movie.class);
		return savedMovieRecord;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Movie updateMovie(Movie movie) {
		movie.setUpdatedAt(new Timestamp(new Date().getTime()));
		movie.setUpdatedBy("superuser");
		MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
		movieEntity = movieRepository.saveAndFlush(movieEntity);
		Movie savedMovieRecord = modelMapper.map(movieEntity, Movie.class);
		return savedMovieRecord;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteMovieById(long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> getMovieByName(String name) {
		List<MovieEntity> movieEntityList = movieRepository.findByName(name); 
		if (!CollectionUtils.isEmpty(movieEntityList)) {
			Type movieListType = new TypeToken<List<Movie>>(){}.getType();
			return modelMapper.map(movieEntityList, movieListType);
		}
		return Collections.emptyList();
	}

	@Override
	public ListPage getMoviesGreaterThanOrEqual(BigDecimal chargePerDay, Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable pageable = Util.getPageable(pageNo, pageSize, sortBy, sortOrder);
		Page<MovieEntity> movieEntityList = movieRepository.findByChargePerDayGreaterThanEqual(chargePerDay, pageable); 
		if (movieEntityList != null && movieEntityList.getSize() > 0) {
			Type movieListType = new TypeToken<List<Movie>>(){}.getType();
			List<MovieEntity> fectedMovieList = modelMapper.map(movieEntityList.getContent(), movieListType);
			ListPage listPage = new ListPage();
			listPage.setList(fectedMovieList);
			listPage.setTotal(fectedMovieList.size());
			listPage.setStartIndex(pageNo);
			listPage.setEndIndex(pageSize);
			listPage.setSortBy(sortBy);
			listPage.setSortOrder(sortOrder);
			return listPage;
		}
		return new ListPage();
	}

	@Override
	public ListPage getMoviesLessThanOrEqual(BigDecimal chargePerDay, Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable pageable = Util.getPageable(pageNo, pageSize, sortBy, sortOrder);
		Page<MovieEntity> movieEntityList = movieRepository.findByChargePerDayLessThanEqual(chargePerDay, pageable); 
		if (movieEntityList != null && movieEntityList.getSize() > 0) {
			Type movieListType = new TypeToken<List<Movie>>(){}.getType();
			List<MovieEntity> fectedMovieList = modelMapper.map(movieEntityList.getContent(), movieListType);
			ListPage listPage = new ListPage();
			listPage.setList(fectedMovieList);
			listPage.setTotal(fectedMovieList.size());
			listPage.setStartIndex(pageNo);
			listPage.setEndIndex(pageSize);
			listPage.setSortBy(sortBy);
			listPage.setSortOrder(sortOrder);
			return listPage;
		}
		return new ListPage();
	}

	@Override
	public Movie getMovieById(long id) {
		MovieEntity movieEntity = movieRepository.findById(id);
		if(movieEntity != null) {
			return modelMapper.map(movieEntity, Movie.class);
		}
		return null;
	}

}
