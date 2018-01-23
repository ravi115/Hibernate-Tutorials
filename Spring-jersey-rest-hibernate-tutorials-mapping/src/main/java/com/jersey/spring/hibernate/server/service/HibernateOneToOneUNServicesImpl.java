package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.spring.hibernate.model.un.onetoone.Instructor;
import com.jersey.spring.hibernate.server.repository.HibernateOneToOneUNRespository;

@Service
public class HibernateOneToOneUNServicesImpl implements HibernateOneToOneUNServices {

	@Autowired
	HibernateOneToOneUNRespository hibernateOneToOneRespository;
	
	@Override
	public List<Instructor> getAllInstructors() {
		
		return hibernateOneToOneRespository.getAllInstructors();
	}

	@Override
	public Instructor getInstructor(int id) {
		
		return hibernateOneToOneRespository.getInstructor(id);
	}

	@Override
	public int add(Instructor instructor) {
		
		return hibernateOneToOneRespository.add(instructor);
	}

	@Override
	public void update(int id, Instructor instructor) {
		
		hibernateOneToOneRespository.update(id, instructor);
	}

	@Override
	public void delete(int id) {
		hibernateOneToOneRespository.delete(id);

	}

}
