package com.jersey.spring.hibernate.server.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.hibernate.model.bd.onetoone.Professor;
import com.jersey.spring.hibernate.model.bd.onetoone.ProfessorDetails;
import com.jersey.spring.hibernate.server.service.HibernateOneToOneBDServices;

@Path("/OneToOne/bidirectional")
public class HibernateOneToOneBDResources {

	@Autowired
	HibernateOneToOneBDServices hibernateOneToOneBDServices;

	@GET
	@Path("/professors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProfessors() {

		List<Professor> professors = hibernateOneToOneBDServices.getAllProfessor();

		return Response.ok().status(200).entity(professors).build();
	}

	@GET
	@Path("/professors/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProfessorDetails() {

		List<ProfessorDetails> professorsDetails = hibernateOneToOneBDServices.getAllProfessorDetails();

		return Response.ok().status(200).entity(professorsDetails).build();
	}

	@GET
	@Path("/professors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfessor(@PathParam("id") int id) {

		Professor professors = hibernateOneToOneBDServices.getProfessor(id);

		return Response.ok().status(200).entity(professors).build();
	}

	@GET
	@Path("/professors/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfessorDetail(@PathParam("id") int id) {

		ProfessorDetails professorsDetails = hibernateOneToOneBDServices.getProfessorDetails(id);

		return Response.ok().status(200).entity(professorsDetails).build();
	}

	@POST
	@Path("/professors")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(Professor professor, @Context UriInfo uriInfo ) {

		long id = hibernateOneToOneBDServices.add(professor);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@POST
	@Path("/professors/details")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessorDetails(ProfessorDetails professorDetails, @Context UriInfo uriInfo) {

		long id = hibernateOneToOneBDServices.add(professorDetails);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}
	
	@PUT
	@Path("/professors/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfessor(@PathParam("id") int id, Professor professor, @Context UriInfo uriInfo) {

		hibernateOneToOneBDServices.update(id, professor);
		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@PUT
	@Path("/professors/details/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfessorDetails(@PathParam("id") int id, ProfessorDetails professorDetails, @Context UriInfo uriInfo) {

		hibernateOneToOneBDServices.update(id, professorDetails);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@DELETE
	@Path("/professors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProfessor(@PathParam("id") int id) {

		hibernateOneToOneBDServices.deleteProfessor(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}

	@DELETE
	@Path("/professors/details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProfessorDetail(@PathParam("id") int id) {

		hibernateOneToOneBDServices.deleteProfessorDetails(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}
}
