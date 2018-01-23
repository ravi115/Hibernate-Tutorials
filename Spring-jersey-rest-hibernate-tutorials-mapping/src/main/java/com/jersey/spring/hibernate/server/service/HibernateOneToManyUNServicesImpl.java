package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.spring.hibernate.model.un.onetomany.MotorCycles;
import com.jersey.spring.hibernate.model.un.onetomany.Person;
import com.jersey.spring.hibernate.server.repository.HibernateOneToManyUNRespository;

@Service
public class HibernateOneToManyUNServicesImpl implements HibernateOneToManyUNServices {

	@Autowired
	HibernateOneToManyUNRespository hibernateOneToManyUNRespository;
	
	@Override
	public List<Person> getAllPerson() {
		
		return hibernateOneToManyUNRespository.getAllPerson();
	}

	@Override
	public List<MotorCycles> getAllMotorCycles() {
		
		return hibernateOneToManyUNRespository.getAllMotorCycles();
	}

	@Override
	public Person getPerson(int id) {
		
		return hibernateOneToManyUNRespository.getPerson(id);
	}

	@Override
	public MotorCycles getMotorCycles(int id) {
		
		return hibernateOneToManyUNRespository.getMotorCycles(id);
	}

	@Override
	public int add(Person Person) {
		
		return hibernateOneToManyUNRespository.add(Person);
	}

	@Override
	public int add(MotorCycles MotorCycles) {
		
		return hibernateOneToManyUNRespository.add(MotorCycles);
	}

	@Override
	public void update(int id, Person Person) {
		
		hibernateOneToManyUNRespository.update(id, Person);
	}

	@Override
	public void update(int id, MotorCycles MotorCycles) {
		hibernateOneToManyUNRespository.update(id, MotorCycles);

	}

	@Override
	public void deletePerson(int id) {
		hibernateOneToManyUNRespository.deletePerson(id);

	}

	@Override
	public void deleteMotorCycles(int id) {
		hibernateOneToManyUNRespository.deleteMotorCycles(id);

	}

}
