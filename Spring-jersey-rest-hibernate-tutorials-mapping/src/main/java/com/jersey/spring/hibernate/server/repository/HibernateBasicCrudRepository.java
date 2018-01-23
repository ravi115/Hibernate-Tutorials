package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.model.basic.User;

public interface HibernateBasicCrudRepository {

	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public int add(User user);
	
	public void update(int id, User user);
	
	public void delete(int id);
}
