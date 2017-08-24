package com.movieworld.service;

import java.util.List;

import com.movieworld.entity.Movie;

public interface MovieService {
	
	public  List<Movie> findAll();
	
	public  Movie findOne(String id);
	
	public Movie create(Movie title);
	
	public Movie update(Movie title); 
	
	public void delete(String title);

	
}
