package com.movieworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.entity.User;
import com.movieworld.exception.UserAlreadyExistsException;
import com.movieworld.exception.UserNotFoundException;
import com.movieworld.repository.UserRepository;



@Service("userService")
@Transactional
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public User findByEmail(String email) {
		User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new UserNotFoundException("User with email:" + email + " not found");
		}
		return existing;
	}
	
	@Override
	@Transactional
	public User create(User email) {
		User existing = repository.findByEmail(email.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + email);
		}
		return repository.save(email);
	}


	@Override
	@Transactional
	public User update(User email) {
		User existing = repository.findByEmail(email.getEmail());
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + email.getEmail() + " not found");
		}
		return repository.save(email);
	}

	@Override
	@Transactional
	public void delete(String email) {
	User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + email + " not found");
		}
		repository.delete(existing);
	}
	
	public User findById(int id) {
		return repository.findById(id);
	}


}
