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

import com.jersey.spring.hibernate.model.un.onetomany.MotorCycles;
import com.jersey.spring.hibernate.model.un.onetomany.Person;
import com.jersey.spring.hibernate.server.service.HibernateOneToManyUNServices;

@Path("/OneToMany/unidirectional")
public class HibernateOneToManyUNResources {

	@Autowired
	HibernateOneToManyUNServices hibernateOneToManyUNServices;

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPerson() {

		List<Person> persons = hibernateOneToManyUNServices.getAllPerson();

		return Response.ok().status(200).entity(persons).build();
	}

	@GET
	@Path("/motorcycles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMotorCycles() {

		List<MotorCycles> motorcycles = hibernateOneToManyUNServices.getAllMotorCycles();

		return Response.ok().status(200).entity(motorcycles).build();
	}

	@GET
	@Path("/persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") int id) {

		Person Person = hibernateOneToManyUNServices.getPerson(id);

		return Response.ok().status(200).entity(Person).build();
	}

	@GET
	@Path("/motorcycles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMotorCycles(@PathParam("id") int id) {

		MotorCycles motorcycles = hibernateOneToManyUNServices.getMotorCycles(id);

		return Response.ok().status(200).entity(motorcycles).build();
	}

	@POST
	@Path("/persons")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPerson(Person Person, @Context UriInfo uriInfo ) {

		long id = hibernateOneToManyUNServices.add(Person);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@POST
	@Path("/motorcycles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMotorCycles(MotorCycles motorcycles, @Context UriInfo uriInfo) {

		long id = hibernateOneToManyUNServices.add(motorcycles);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}
	
	@PUT
	@Path("/persons/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(@PathParam("id") int id, Person Person, @Context UriInfo uriInfo) {

		hibernateOneToManyUNServices.update(id, Person);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@PUT
	@Path("/motorcycles/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMotorCycles(@PathParam("id") int id, MotorCycles motorcycles, @Context UriInfo uriInfo) {

		hibernateOneToManyUNServices.update(id, motorcycles);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@DELETE
	@Path("/persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("id") int id) {

		hibernateOneToManyUNServices.deletePerson(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}

	@DELETE
	@Path("/motorcycles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMotorCycles(@PathParam("id") int id) {

		hibernateOneToManyUNServices.deleteMotorCycles(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}
}
