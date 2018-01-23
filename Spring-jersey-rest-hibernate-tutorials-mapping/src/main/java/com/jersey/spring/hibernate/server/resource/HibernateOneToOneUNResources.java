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

import com.jersey.spring.hibernate.model.un.onetoone.Instructor;
import com.jersey.spring.hibernate.server.service.HibernateOneToOneUNServices;

@Path("/OneToOne/unidirectional")
public class HibernateOneToOneUNResources {

	@Autowired
	HibernateOneToOneUNServices hibernateOneToOneServices;
	
	@GET
	@Path("/Instructors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {

		List<Instructor> instructor = hibernateOneToOneServices.getAllInstructors();

		return Response.ok().status(200).entity(instructor).build();
	}

	@GET
	@Path("/Instructors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id) {

		Instructor user = hibernateOneToOneServices.getInstructor(id);
		return Response.ok().status(200).entity(user).build();
	}

	@POST
	@Path("/Instructors")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(Instructor instructor, @Context UriInfo uriInfo) {

		Long id = (long) hibernateOneToOneServices.add(instructor);
		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@PUT
	@Path("/Instructors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, Instructor instructor, @Context UriInfo uriInfo) {

		hibernateOneToOneServices.update(id, instructor);
		
		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	
		
	}

	@DELETE
	@Path("/instructors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {

		hibernateOneToOneServices.delete(id);
		return Response.ok().status(200).entity("{\"status\": \" deleted\"}").build();
	}
}
