package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.spring.hibernate.model.bd.onetoone.Professor;
import com.jersey.spring.hibernate.model.bd.onetoone.ProfessorDetails;
import com.jersey.spring.hibernate.server.repository.HibernateOneToOneBDRespository;

@Service
public class HibernateOneToOneBDServicesImpl implements HibernateOneToOneBDServices {

	
	@Autowired
	HibernateOneToOneBDRespository hibernateOneToOneBDRespository;
	
	@Override
	public List<Professor> getAllProfessor() {
		
		return hibernateOneToOneBDRespository.getAllProfessor();
	}

	@Override
	public List<ProfessorDetails> getAllProfessorDetails() {
		
		return hibernateOneToOneBDRespository.getAllProfessorDetails();
	}

	@Override
	public Professor getProfessor(int id) {
		
		return hibernateOneToOneBDRespository.getProfessor(id);
	}

	@Override
	public ProfessorDetails getProfessorDetails(int id) {
		
		return hibernateOneToOneBDRespository.getProfessorDetails(id);
	}

	@Override
	public int add(Professor professor) {
		
		return hibernateOneToOneBDRespository.add(professor);
	}

	@Override
	public int add(ProfessorDetails professorDetails) {
		
		return hibernateOneToOneBDRespository.add(professorDetails);
	}

	@Override
	public void update(int id, Professor professor) {
		
		hibernateOneToOneBDRespository.update(id, professor);

	}

	@Override
	public void update(int id, ProfessorDetails professorDetails) {
		
		hibernateOneToOneBDRespository.update(id, professorDetails);
	}

	@Override
	public void deleteProfessor(int id) {
		
		hibernateOneToOneBDRespository.deleteProfessor(id);
	}

	@Override
	public void deleteProfessorDetails(int id) {
		
		hibernateOneToOneBDRespository.deleteProfessorDetails(id);
	}

}
