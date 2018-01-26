package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.TicketBooking;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class TicketBookingRepositoryImpl implements TicketBookingRepository {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<TicketBooking> getAllBookedTicket() {
		
		Session session = sessionFactory.getCurrentSession();
		List<TicketBooking> ticketBooking = session
				.createQuery("FROM TicketBooking", TicketBooking.class).getResultList();
		return ticketBooking;
	}

	@Override
	public TicketBooking getTicketBooking(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TicketBooking.class, id);
	}

	@Override
	public String add(TicketBooking ticketBooking) {
		Session session = sessionFactory.getCurrentSession();
		return (String) session.save(ticketBooking);
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		TicketBooking ticketBooking = session.get(TicketBooking.class, id);
		session.delete(ticketBooking);
	}

}
