package com.movieworld.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieworld.constants.URI;
import com.movieworld.entity.User;
import com.movieworld.service.UserService;


@Controller
@ResponseBody
@RequestMapping(path = URI.USERS)
public class UserController  {
	
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
	public User findOne(@PathVariable("id") String email) {
		return service.findByEmail(email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User email) {
		return service.create(email);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
	public User update(@PathVariable("id") String email, @RequestBody User user) {
		return service.update(email, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
	public void delete(@PathVariable("id") String email) {
		service.delete(email);
	}

}
