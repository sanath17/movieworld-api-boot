package com.movieworld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.entity.Movie;
import com.movieworld.exception.MovieNotFoundException;
import com.movieworld.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository repository;

	public MovieServiceImpl(MovieRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		return repository.findOne(id)
				.orElseThrow(() -> new MovieNotFoundException("User with id " + id + " does not exist"));
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Optional<Movie> existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new MovieNotFoundException("Movie with " + movie.getTitle() + "already exists");
		}
		return repository.save(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		repository.findOne(id).orElseThrow(() -> new MovieNotFoundException("User with id " + id + " does not exist"));
		return repository.save(movie);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id)
				.orElseThrow(() -> new MovieNotFoundException("User with id " + id + " does not exist"));
		repository.delete(existing);
	}

}
