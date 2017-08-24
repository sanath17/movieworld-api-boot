package com.movieworld.service;

import java.util.List;

import com.movieworld.entity.User;

public interface UserService {

	List<User> findAll();

	User findByEmail(String email);

	User create(User email);

	User update(String email, User user);

	void delete(String email);

}
