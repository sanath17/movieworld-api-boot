package com.movieworld.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.movieworld.entity.Movie;

public interface MovieRepository extends Repository<Movie, String> {

	public  List<Movie> findAll();
	
	public  Movie findByTitle(String title);
	
	public Movie findOne(String id);
	
	public Movie save(Movie movie);
	
	public void delete(Movie title);


}
