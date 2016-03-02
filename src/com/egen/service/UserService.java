package com.egen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.egen.entity.User;
import com.egen.exceptionHandlers.BadRequestByUser;
import com.egen.exceptionHandlers.UserNotFoundException;

@Service
public class UserService {	
	private Map<String,User> store;
	private  String validateName = "[A-Za-z]+";
	private String validateAge = "[0-9]+";
	private String validateEmail = "[A-Za-z0-9]+(@gmail.com|@yahoo.com|@outlook.com|@mail.com|@inbox.com|@gmail.co.in)";
	public UserService()
	{
		// Temparary Dump of the Data
		store = new HashMap<String, User>();
		User u1 = new User();
		u1.setId("1");
		u1.setFname("Ditz");
		u1.setLname("Jose");
		u1.setEmail("ditzjose@gmail.com");
		u1.setAge("26");
		u1.setPassword("1212Sophy");

		User u2 = new User();
		u2.setId("2");
		u2.setFname("Tittu");
		u2.setLname("Jose");
		u2.setEmail("tittujose@gmail.com");
		u2.setAge("30");
		u2.setPassword("1212Tittu");
		
		User u3 = new User();
		u3.setId("3");
		u3.setFname("Surya");
		u3.setLname("Nanda");
		u3.setEmail("tsuryaNanda@gmail.com");
		u3.setAge("23");
		u3.setPassword("1212SuryaMylarPass");
		
		User u4 = new User();
		u4.setId("4");
		u4.setFname("Rahda");
		u4.setLname("Butt");
		u4.setEmail("radhaButt@gmail.com");
		u4.setAge("30");
		u4.setPassword("1212raddhButt");
		
		store.put(u1.getId(), u1);
		store.put(u2.getId(), u2);
		store.put(u3.getId(), u3);
		store.put(u4.getId(), u4);
	
	}

	public List<User> findAll()
	{
		 List<User> user = new ArrayList<User>(store.values());	
		 return user;
	}
	
	public User  findOne(String id ) throws UserNotFoundException 
	{
		if(store.containsKey(id))
		{
			return store.get(id);
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
			store.put(user.getId(), user);
			return user;
		}
		else
		{
			throw new BadRequestByUser();
		}
		
	}
	
	public User update( String id ,User user) throws UserNotFoundException
	{
		if(store.containsKey(id))
		{
			return store.put(id, user);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
	public User delete(String id ) throws UserNotFoundException
	{
		if(store.containsKey(id))
		{
			return store.remove(id);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
}
