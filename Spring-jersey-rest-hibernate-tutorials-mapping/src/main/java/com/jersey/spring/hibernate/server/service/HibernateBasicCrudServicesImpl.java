package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.spring.hibernate.model.basic.User;
import com.jersey.spring.hibernate.server.repository.HibernateBasicCrudRepository;

@Service
public class HibernateBasicCrudServicesImpl implements HibernateBasicCrudServices {

	@Autowired
	HibernateBasicCrudRepository hibernateBasicCrudRepository;

	@Override
	public List<User> getAllUsers() {

		return hibernateBasicCrudRepository.getAllUsers();
	}

	@Override
	public User getUser(int id) {

		return hibernateBasicCrudRepository.getUser(id);
	}

	@Override
	public int add(User user) {

		return hibernateBasicCrudRepository.add(user);
	}

	@Override
	public void update(int id, User user) {

		hibernateBasicCrudRepository.update(id, user);

	}

	@Override
	public void delete(int id) {

		hibernateBasicCrudRepository.delete(id);
	}

}
