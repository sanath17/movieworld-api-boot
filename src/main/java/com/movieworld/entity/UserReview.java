package com.movieworld.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class UserReview {

	@Id
	private String Rid;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Movie movie;
	
	private String comments;
	
	private int user_ratings;
	
	public UserReview() {
		this.Rid = UUID.randomUUID().toString();
	}

	public String getId() {
		return Rid;
	}

	public void setId(String id) {
		this.Rid = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getUser_ratings() {
		return user_ratings;
	}

	public void setUser_ratings(int user_ratings) {
		this.user_ratings = user_ratings;
	}
}
