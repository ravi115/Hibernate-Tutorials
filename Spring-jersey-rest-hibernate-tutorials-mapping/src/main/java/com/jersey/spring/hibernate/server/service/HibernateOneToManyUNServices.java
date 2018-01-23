package com.jersey.spring.hibernate.server.service;

import java.util.List;

import com.jersey.spring.hibernate.model.un.onetomany.MotorCycles;
import com.jersey.spring.hibernate.model.un.onetomany.Person;

public interface HibernateOneToManyUNServices {
	public List<Person> getAllPerson();

	public List<MotorCycles> getAllMotorCycles();

	public Person getPerson(int id);

	public MotorCycles getMotorCycles(int id);

	public int add(Person Person);

	public int add(MotorCycles MotorCycles);

	public void update(int id, Person Person);

	public void update(int id, MotorCycles MotorCycles);

	public void deletePerson(int id);

	public void deleteMotorCycles(int id);
}
