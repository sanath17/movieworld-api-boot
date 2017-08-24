package com.movieworld.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.movieworld.entity.Movie;

public interface MovieRepository extends Repository<Movie, String> {

	public  List<Movie> findAll();
	
	public  Optional<Movie> findByTitle(String title);
	
	public Optional<Movie> findOne(String id);
	
	public Movie save(Movie movie);
	
	public void delete(Movie title);


}
