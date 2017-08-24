package com.movieworld.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.movieworld.entity.UserReview;

public interface UserReviewRepository extends Repository<UserReview, String> {

	public List<UserReview> findAll();

	public Optional<UserReview> findOne(String id);

	public UserReview save(UserReview comments);

	public void delete(UserReview comments);
}
