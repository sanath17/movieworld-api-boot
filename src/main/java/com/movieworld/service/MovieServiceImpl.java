package com.movieworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.entity.Movie;
import com.movieworld.exception.*;
import com.movieworld.repository.MovieRepository;

@Service
@EnableTransactionManagement
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repository;

	@Override
	public List<Movie> findAll() {

		return repository.findAll();
	}

	
	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + id + "notfound");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new MovieNotFoundException("Movie with " + movie.getTitle() + "already exists");
		}
		return repository.save(movie);
	}

	@Override
	@Transactional
	public Movie update(Movie title) {
		Movie existing = repository.findByTitle(title.getTitle());
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + title.getTitle() + "notfound");
		}
		return repository.save(title);
	}

	@Override
	@Transactional
	public void delete(String title) {
		Movie existing = repository.findByTitle(title);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + title + "notfound");
		}
		repository.delete(existing);
	}

}
