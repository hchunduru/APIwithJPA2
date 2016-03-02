package com.egen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.egen.entity.Movie;
import com.egen.exceptionHandlers.BadRequestOnMovie;
import com.egen.exceptionHandlers.MovieNotFoundException;

@Service
public class MovieService {
	private Map<String,Movie> store;
	private String validateLength= "[0-9]+";
	public MovieService()
	{
		store =new HashMap<String,Movie>();
		Movie movie1 = new Movie();
		Movie movie2 = new Movie();
		
		movie1.setmId("1");
		movie1.setmName("Matrix");
		movie1.setmLength("128");
		movie1.setmDescription("Action Genre");
		
		movie2.setmId("2");
		movie2.setmName("Love in Seattle");
		movie2.setmLength("100");
		movie2.setmDescription("Romance Genre");
		
		store.put(movie1.getmId(), movie1);
		store.put(movie2.getmId(), movie2);
		
	}
	
	public List<Movie> findAllMovie()
	{
		List<Movie> movies = new ArrayList<Movie>(store.values()); 
		return movies;
	}
	
	public Movie  findOneMovie(String id ) throws  MovieNotFoundException
	{
		if(store.containsKey(id))
		{
			return store.get(id);
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
			
			store.put(movie.getmId(), movie);
			return movie;
		}
		else
		{
			throw new BadRequestOnMovie();
		}
		
	}
	
	public Movie update( String id ,Movie movie) throws MovieNotFoundException
	{
		if(store.containsKey(id))
		{
			return store.put(id, movie);
		}
		else
		{
			throw new MovieNotFoundException();
		}
	}
	
	
	public Movie delete(String id ) throws MovieNotFoundException
	{
		if(store.containsKey(id))
		{
			return store.remove(id);
		}
		else
		{
			throw new MovieNotFoundException();
		}
	}
}
