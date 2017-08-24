package com.movieworld.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.movieworld.entity.UserReview;

public interface UserReviewRepository extends Repository<UserReview, String> {

	public List<UserReview> findAll();

	public UserReview findOne(UserReview id);

	public UserReview save(UserReview comments);

	public void delete(UserReview comments);
}
