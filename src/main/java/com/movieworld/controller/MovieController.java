package com.movieworld.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieworld.constants.URI;
import com.movieworld.entity.Movie;
import com.movieworld.service.MovieService;


@Controller
@ResponseBody
@RequestMapping(path = URI.Movie)
public class MovieController  {
	
	
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Movie> findAll(){
		return service.findAll();	
	}
	
//	@RequestMapping(method=RequestMethod.GET, path= "{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findBytitle(@PathVariable("title") String title) {
//		return service.findByTitle(title);
//	}
	
	@RequestMapping(method=RequestMethod.GET, value = URI.ID)
	public Movie findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

    
//	@RequestMapping(method=RequestMethod.GET, path= "{genere}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByGenere(@PathVariable("genere") String genere) {
//		return service.findByGenere(genere);
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, path= "{ratings}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByRatings(@PathVariable("ratings") int ratings) {
//		return service.findByRatings(ratings);
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, path= "{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByType(@PathVariable("type") String type) {
//		return service.findByType(type);
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Movie create(@RequestBody Movie title) {
		return service.create(title);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = URI.ID)
	public Movie update(@PathVariable("title")String id, Movie title) {
		return service.update(id,title);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = URI.ID )
	public void delete(@PathVariable("id") String id) {
		 service.delete(id);
	}
		
	
}
