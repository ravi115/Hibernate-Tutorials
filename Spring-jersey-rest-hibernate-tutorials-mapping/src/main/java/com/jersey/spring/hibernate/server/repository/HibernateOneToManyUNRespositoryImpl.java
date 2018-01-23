package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.model.un.onetomany.MotorCycles;
import com.jersey.spring.hibernate.model.un.onetomany.Person;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class HibernateOneToManyUNRespositoryImpl implements HibernateOneToManyUNRespository {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Person> getAllPerson() {
		
		return null;
	}

	@Override
	public List<MotorCycles> getAllMotorCycles() {
		
		return null;
	}

	@Override
	public Person getPerson(int id) {
		
		return null;
	}

	@Override
	public MotorCycles getMotorCycles(int id) {
		
		return null;
	}

	@Override
	public int add(Person Person) {
		
		return 0;
	}

	@Override
	public int add(MotorCycles MotorCycles) {
		
		return 0;
	}

	@Override
	public void update(int id, Person Person) {
		

	}

	@Override
	public void update(int id, MotorCycles MotorCycles) {
		

	}

	@Override
	public void deletePerson(int id) {
		

	}

	@Override
	public void deleteMotorCycles(int id) {
		

	}

}
