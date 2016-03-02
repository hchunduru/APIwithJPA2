package com.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.dao.MovieDAO;
import com.egen.entity.Movie;
import com.egen.exceptionHandlers.BadRequestOnMovie;
import com.egen.exceptionHandlers.MovieNotFoundException;

@Service
public class MovieService {
	
	private String validateLength= "[0-9]+";
	
	@Autowired
	MovieDAO movieDAO;
	
	public List<Movie> findAllMovie()
	{
		List<Movie> movies = movieDAO.findAllMovie();
		return movies;
	}
	
	public Movie  findOneMovie(String id ) throws  MovieNotFoundException
	{
		Movie movie = movieDAO.findOneMovie(id);
		if(movie != null)
		{
			return movie;
		}
		else
		{
			throw new MovieNotFoundException();
		}
	}
	
	public Movie createMovie(Movie movie) throws BadRequestOnMovie
	{
		movie.setmId(movie.hashCode()+"");
		if(movie.getmLength().matches(validateLength))
		{
			
			movieDAO.createMovie(movie);
			return movie;
		}
		else
		{
			throw new BadRequestOnMovie();
		}
		
	}
	
	public Movie update( String id ,Movie movie) throws MovieNotFoundException
	{
		Movie movie1 = movieDAO.findOneMovie(id);
		if(movie1 != null)
		{
			return movieDAO.update(movie);
		}
		else
		{
			throw new MovieNotFoundException();
		}
	}
	
	
	public Movie delete(String id ) throws MovieNotFoundException
	{
		Movie movie1 = movieDAO.findOneMovie(id);
		if(movie1 != null)
		{
			return movieDAO.delete(id);
		}
		else
		{
			throw new MovieNotFoundException();
		}
	}
}
