package com.jersey.spring.hibernate.server.service;

import java.util.List;

import com.jersey.spring.hibernate.model.un.onetoone.Instructor;

public interface HibernateOneToOneUNServices {

	public List<Instructor> getAllInstructors();

	public Instructor getInstructor(int id);

	public int add(Instructor instructor);

	public void update(int id, Instructor instructor);

	public void delete(int id);
}
