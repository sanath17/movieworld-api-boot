package com.movieworld.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.entity.UserReview;
import com.movieworld.exception.UserNotFoundException;
import com.movieworld.repository.UserReviewRepository;

@Service
public class UserReviewServiceImpl implements UserReviewService {
	
	private UserReviewRepository repository;

	public UserReviewServiceImpl(UserReviewRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<UserReview> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UserReview findOne(String id) {
		return repository.findOne(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
	}

	@Override
	@Transactional
	public UserReview create(UserReview comments) {
		return repository.save(comments);
	}

	@Override
	@Transactional
	public UserReview update(String id, UserReview comments) {
		repository.findOne(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
		return repository.save(comments);
	}

	@Override
	@Transactional
	public void delete(String id) {
		UserReview existing = repository.findOne(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
		repository.delete(existing);
	}

}
