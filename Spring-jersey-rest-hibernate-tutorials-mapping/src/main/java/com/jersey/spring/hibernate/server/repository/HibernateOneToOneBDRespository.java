package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.model.bd.onetoone.Professor;
import com.jersey.spring.hibernate.model.bd.onetoone.ProfessorDetails;

public interface HibernateOneToOneBDRespository {

	
	public List<Professor> getAllProfessor();
	
	public List<ProfessorDetails> getAllProfessorDetails();
	
	public Professor getProfessor(int id);
	
	public ProfessorDetails getProfessorDetails(int id);
	
	public int add(Professor professor);
	
	public int add(ProfessorDetails professorDetails);
	
	public void update(int id, Professor professor);
	
	public void update(int id, ProfessorDetails professorDetails);
	
	public void deleteProfessor(int id);
	
	public void deleteProfessorDetails(int id);
}
