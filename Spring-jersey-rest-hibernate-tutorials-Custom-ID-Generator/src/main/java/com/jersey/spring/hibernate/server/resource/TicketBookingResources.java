package com.jersey.spring.hibernate.server.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.hibernate.server.model.TicketBooking;
import com.jersey.spring.hibernate.server.repository.TicketBookingRepository;


@Path("/booking")
public class TicketBookingResources {

	@Autowired
	TicketBookingRepository ticketBookingRepository;
	
	@GET
	@Path("/tickets")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBookedTickets() {
		
		List<TicketBooking> tickets = ticketBookingRepository.getAllBookedTicket();
		return Response.ok().status(200).entity(tickets).build();
	}
	
	@GET
	@Path("/tickets/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookedTickets(@PathParam("id") String id) {
		
		TicketBooking ticketBooking = ticketBookingRepository.getTicketBooking(id);
		return Response.ok().status(200).entity(ticketBooking).build();
	}
	
	@POST
	@Path("/tickets")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(TicketBooking ticketBooking, @Context UriInfo uriInfo) {
		
		String id = ticketBookingRepository.add(ticketBooking);
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		
		return Response.ok().status(201).entity(uri).build();
	}
	
	@DELETE
	@Path("/tickets/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {
		
		ticketBookingRepository.delete(id);
		return Response.ok().status(200).entity("{\"status\":\"deleted\"}").build();
	}
}
