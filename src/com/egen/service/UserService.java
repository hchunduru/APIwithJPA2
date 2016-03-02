package com.egen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.dao.UserDao;
import com.egen.entity.User;
import com.egen.exceptionHandlers.BadRequestByUser;
import com.egen.exceptionHandlers.UserNotFoundException;

@Service
public class UserService {	

	private  String validateName = "[A-Za-z]+";
	private String validateAge = "[0-9]+";
	private String validateEmail = "[A-Za-z0-9]+(@gmail.com|@yahoo.com|@outlook.com|@mail.com|@inbox.com|@gmail.co.in)";
	
	@Autowired
	UserDao userDAO;
	
	public List<User> findAll()
	{
		List<User>  user = userDAO.findAll();
		 return user;
	}
	
	public User  findOne(String id ) throws UserNotFoundException 
	{
		User user = userDAO.findOne(id);
		if(user != null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
	
	public User createUser(User user) throws BadRequestByUser
	{
		user.setId(user.hashCode()+"");
		if(user.getFname().matches(validateName) && user.getLname().matches(validateName)  && user.getEmail().matches(validateEmail) && user.getAge().matches(validateAge) )
		{
			userDAO.createUser(user);
			return user;
		}
		else
		{
			throw new BadRequestByUser();
		}
		
	}
	
	public User update( String id ,User user) throws UserNotFoundException
	{
		User user1 = userDAO.findOne(id);
		if(user1 != null)
		{
			return userDAO.update(user);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
	public User delete(String id ) throws UserNotFoundException
	{
		User user1 = userDAO.findOne(id);
		if(user1 != null)
		{
			return userDAO.delete(id);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
}
