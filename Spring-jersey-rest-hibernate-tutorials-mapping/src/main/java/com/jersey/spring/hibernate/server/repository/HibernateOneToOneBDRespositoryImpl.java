package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.model.bd.onetoone.Professor;
import com.jersey.spring.hibernate.model.bd.onetoone.ProfessorDetails;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class HibernateOneToOneBDRespositoryImpl implements HibernateOneToOneBDRespository {

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * 
	 */
	@Override
	public List<Professor> getAllProfessor() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Professor> professors = session.createQuery("FROM Professor", Professor.class)
											.getResultList();
		return professors;
	}

	/**
	 * 
	 */
	@Override
	public List<ProfessorDetails> getAllProfessorDetails() {
		
		Session session = sessionFactory.getCurrentSession();
		List<ProfessorDetails> professorDetails = 
				session.createQuery("FROM ProfessorDetails", ProfessorDetails.class).getResultList();
		return professorDetails;
	}

	/**
	 * 
	 */
	@Override
	public Professor getProfessor(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Professor professor = session.get(Professor.class, id);
		return professor;
	}

	/**
	 * 
	 */
	@Override
	public ProfessorDetails getProfessorDetails(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		ProfessorDetails professorDetails = session.get(ProfessorDetails.class, id);
		return professorDetails;
	}

	/**
	 * 
	 */
	@Override
	public int add(Professor professor) {
		
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(professor);
		return id;
	}

	/**
	 * 
	 */
	@Override
	public int add(ProfessorDetails professorDetails) {
		
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(professorDetails);
		return id;
	}

	/**
	 * 
	 */
	@Override
	public void update(int id, Professor professor) {
		
		Session session = sessionFactory.getCurrentSession();
		Professor theProfessor = session.get(Professor.class, id);
		
		//update the professor
		if(professor.getFirstName() != null && professor.getFirstName().length() > 0 )
			theProfessor.setFirstName(professor.getFirstName());
		if(professor.getLastName() != null && professor.getLastName().length() > 0)
			theProfessor.setLastName(professor.getLastName());
		if(professor.getEmail() != null && professor.getEmail().length() > 0 )
			theProfessor.setEmail(professor.getEmail());
		
		//update professor details for this professor
		ProfessorDetails theProfessorDetails = theProfessor.getProfessorDetails();
		
		if(professor.getProfessorDetails().getYoutubeChannel() != null && professor.getProfessorDetails().getYoutubeChannel().length() > 0)
			theProfessorDetails.setYoutubeChannel(professor.getProfessorDetails().getYoutubeChannel());
		if(professor.getProfessorDetails().getHobby() != null && professor.getProfessorDetails().getHobby().length() > 0)
			theProfessorDetails.setHobby(professor.getProfessorDetails().getHobby());
		
		//update professor
		session.update(theProfessor);
		
		//update professor details
		session.update(theProfessorDetails);
	}

	/**
	 * 
	 */
	@Override
	public void update(int id, ProfessorDetails professorDetails) {
		
		//update only professorDetails if we have the row id.
		Session session = sessionFactory.getCurrentSession();
		
		ProfessorDetails theProfessorDetails= session.get(ProfessorDetails.class, id);
		
		if(professorDetails.getYoutubeChannel() != null && professorDetails.getYoutubeChannel().length() > 0)
			theProfessorDetails.setYoutubeChannel(professorDetails.getYoutubeChannel());
		if(professorDetails.getHobby() != null && professorDetails.getHobby().length() > 0)
			theProfessorDetails.setHobby(professorDetails.getHobby());
		
		//save professor details
		session.update(theProfessorDetails);
	}

	/**
	 * 
	 */
	@Override
	public void deleteProfessor(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		int deletedRow = session.createQuery("delete from Professor where id =:id")
				.setParameter("id", id)
				.executeUpdate();
		
		if(deletedRow > 0 ) {
			System.out.println("Deleted Data for id : " + id);
		}

	}

	/**
	 * 
	 */
	@Override
	public void deleteProfessorDetails(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		int deletedRow = session.createQuery("delete from ProfessorDetails where id =:id")
				.setParameter("id", id)
				.executeUpdate();
		
		if(deletedRow > 0 ) {
			System.out.println("Deleted Data for id : " + id);
		}
	}

}
