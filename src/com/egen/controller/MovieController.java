package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.Movie;
import com.egen.exceptionHandlers.BadRequestOnMovie;
import com.egen.exceptionHandlers.MovieNotFoundException;
import com.egen.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService mService;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findAllmovie()
	{
		return mService.findAllMovie();
	}
	
	@RequestMapping(value = "{id}" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie  findOne(@PathVariable("id") String id ) throws  MovieNotFoundException 
	{
		return mService.findOneMovie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie create(@RequestBody Movie movie) throws BadRequestOnMovie
	{
		return mService.createMovie(movie);
	}
	@RequestMapping(value = "{id}" , method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie update(@PathVariable("id") String id ,@RequestBody Movie movie) throws MovieNotFoundException
	{
		return mService.update(id, movie);
	}
	@RequestMapping(value = "{id}" , method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie delete(@PathVariable("id") String id ) throws  MovieNotFoundException
	{
		return mService.delete(id);
	}
	
}
