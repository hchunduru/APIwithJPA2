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
import com.egen.entity.User;
import com.egen.exceptionHandlers.UserNotFoundException;
import com.egen.service.MovieService;
import com.egen.service.UserService;

@RestController
@RequestMapping("/usersActivity")
public class UserActivityController {

	@Autowired
	private UserService service;
	@Autowired
	private MovieService mService;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findAllmovie()
	{
		return mService.findAllMovie();
	}
	
	@RequestMapping(value = "{id}" , method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User update(@PathVariable("id") String id ,@RequestBody User user) throws UserNotFoundException
	{
		return service.update(id, user);
	}
	
	
}
