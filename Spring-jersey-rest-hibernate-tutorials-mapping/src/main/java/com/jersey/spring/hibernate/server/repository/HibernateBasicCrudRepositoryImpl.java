package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jersey.spring.hibernate.model.basic.User;

@Repository
@Transactional
public class HibernateBasicCrudRepositoryImpl implements HibernateBasicCrudRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getAllUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("FROM User", User.class).getResultList();
		
		System.out.println("All Users Retrives from database\n" + users);
		return users;
	}

	@Override
	public User getUser(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.createQuery("FROM User where id = :id", User.class)
								.setParameter("id", id)
								.getSingleResult();
		
		System.out.println("All Users Retrives from database\n" + user);
		return user;

	}

	@Override
	public int add(User user) {
	
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(user);//returns primary key of saved user
		
		return id;
	}

	@Override
	public void update(int id, User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		User theUser  = session.get(User.class, id);
		theUser.setName(user.getName());
		theUser.setCompany(user.getCompany());
		
		session.update(theUser);
	}

	@Override
	public void delete(int id) {
	
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}

}
