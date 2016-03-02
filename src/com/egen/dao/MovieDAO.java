package com.egen.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.egen.entity.Movie;

@Repository
@Transactional
public class MovieDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Movie> findAllMovie()
	{
		TypedQuery<Movie> query1 = entityManager.createQuery("SELECT u FROM Movie u", Movie.class); // User is case sensitive
		List<Movie> movielist = query1.getResultList();
		 return movielist;
	}
	
	public Movie  findOneMovie(String id )
	{

		return entityManager.find(Movie.class, id);
	
	}
	
	public Movie createMovie(Movie movie) 
	{
		
		entityManager.persist(movie);
		return movie;
	}
	
	public Movie update(Movie movie) 
	{
		return entityManager.merge(movie);
	}
	
	
	public Movie delete(String id ) 
	{
		Movie movie =  entityManager.find(Movie.class, id);
		entityManager.remove(id);
		return movie;
	}

	
}
