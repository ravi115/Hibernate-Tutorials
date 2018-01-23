package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.model.un.onetoone.Instructor;
import com.jersey.spring.hibernate.model.un.onetoone.InstructorDetails;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class HibernateOneToOneUNRespositoryImpl implements HibernateOneToOneUNRespository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Instructor> getAllInstructors() {

		Session session = sessionFactory.getCurrentSession();
		List<Instructor> instructor = session.createQuery("FROM Instructor", Instructor.class).getResultList();
		return instructor;
	}

	@Override
	public Instructor getInstructor(int id) {

		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, id);
		return instructor;
	}

	@Override
	public int add(Instructor instructor) {

		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(instructor);
		return id;
	}

	@Override
	public void update(int id, Instructor instructor) {

		updates(id, instructor);
		//updateUsingHQLQuery(id, instructor);
	}

	@Override
	public void delete(int id) {

		deleteUsingHQLQuery(id);

	}


	//TODO: 1. 	update instructor for given Id but don't update the instrcutor_details
	//TODO: 2. 	update the instructor_details for the given instructor id.
	//Note : 	updating instructor_details will be illogical since instructor_details is
	//		associated with each instructor.

	private void updates(int id, Instructor instructor) {

		Session session = sessionFactory.getCurrentSession();
		
		//get the instructor for the requested id.
		Instructor theInstructor = session.get(Instructor.class, id);

		//update the instructor table only
		if(instructor.getFirstName() != null && instructor.getFirstName().length() > 0)
			theInstructor.setFirstName(instructor.getFirstName());
		if(instructor.getLastName() != null && instructor.getLastName().length() > 0)
			theInstructor.setLastName(instructor.getLastName());	
		if(instructor.getEmail() != null && instructor.getEmail().length() > 0)
			theInstructor.setEmail(instructor.getEmail());

		//get the instrucrtor_details for the instructor id
		InstructorDetails theInstructorDetails = session.get(InstructorDetails.class, 
															theInstructor.getInstructorDetails().getId());
		
		//update instrucrtor_details table
		InstructorDetails instructorDetails = instructor.getInstructorDetails();

		if(null != instructorDetails ) {
			
			if(instructorDetails.getYoutubeChannel() != null && instructorDetails.getYoutubeChannel().length() > 0)
				theInstructorDetails.setYoutubeChannel(instructorDetails.getYoutubeChannel());
			if(instructorDetails.getHobby() != null && instructorDetails.getHobby().length() > 0)
				theInstructorDetails.setHobby(instructorDetails.getHobby());
		}

		session.update(theInstructor);
		session.update(theInstructorDetails);
	}


	/**
	 * 
	 * @param id
	 */
	private void deleteUsingHQLQuery(int id) {

		Session session = sessionFactory.getCurrentSession();
		int deletedRow = session.createQuery("delete from Instructor where id=:id")
				.setParameter("id", id)
				.executeUpdate();

		if(deletedRow > 0) {
			System.out.println("deleted succesfully..........");
		}
	}
}
