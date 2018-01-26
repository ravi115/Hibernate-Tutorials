package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.TicketBooking;

public interface TicketBookingRepository {

	public List<TicketBooking> getAllBookedTicket();
	
	public TicketBooking getTicketBooking(String id);
	
	public String add(TicketBooking ticketBooking);
	
	public void delete(String id);
}
