package com.movieworld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.entity.User;
import com.movieworld.exception.UserAlreadyExistsException;
import com.movieworld.exception.UserNotFoundException;
import com.movieworld.repository.UserRepository;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User with id " + email + " does not exist"));
	}
	
	@Override
	@Transactional
	public User create(User user) {
		Optional<User> mayExists = repository.findByEmail(user.getEmail());
		if (mayExists.isPresent()) {
			throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
		}
		return repository.save(user);
	}


	@Override
	@Transactional
	public User update(String email, User user) {
		repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with id " + email + " does not exist"));
		return repository.save(user);
	}
	
	@Override
	@Transactional
	public void delete(String email) {
		User existing = repository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User with id " + email + " does not exist"));
		repository.delete(existing);
	}


}
