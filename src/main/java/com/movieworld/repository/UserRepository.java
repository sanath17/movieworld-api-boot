package com.movieworld.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.movieworld.entity.User;

public interface UserRepository extends Repository<User, String> {

	public List<User> findAll();

	public User findByEmail(String email);

	public User save(User email);

	public void delete(User email);

	public User findById(int id);

}
