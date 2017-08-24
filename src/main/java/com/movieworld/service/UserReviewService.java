package com.movieworld.service;

import java.util.List;

import com.movieworld.entity.UserReview;

public interface UserReviewService {

	public List<UserReview> findAll();

	public UserReview findOne(String id);

	public UserReview create(UserReview comments);

	public UserReview update(String id, UserReview comments);

	public void delete(String comments);

}
