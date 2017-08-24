package com.movieworld.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieworld.constants.URI;
import com.movieworld.entity.UserReview;
import com.movieworld.service.UserReviewService;


@Controller
@ResponseBody
@RequestMapping(path = URI.USERREVIEW)
public class UserReviewController  {
	
	
	private UserReviewService service;
	
	public UserReviewController(UserReviewService service) {
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<UserReview> findAll(){
		return service.findAll();	
	}
	
	@RequestMapping(method=RequestMethod.GET,value = URI.ID)
	public UserReview findOne(@PathVariable("id")  String id) {
		return service.findOne(id);
	}
	

	
	@RequestMapping(method=RequestMethod.POST)
	public UserReview create(@RequestBody UserReview comments) {
		return service.create(comments);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = URI.ID)
	public UserReview update(@PathVariable("id") String id, @RequestBody UserReview comments) {
		return service.update(id, comments);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = URI.ID )
	public void delete(@PathVariable("id") String comments) {
		 service.delete(comments);
	}
	
}
