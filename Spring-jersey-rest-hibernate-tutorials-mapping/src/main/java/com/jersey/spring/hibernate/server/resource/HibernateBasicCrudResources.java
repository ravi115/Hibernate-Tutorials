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

import com.jersey.spring.hibernate.model.basic.User;
import com.jersey.spring.hibernate.server.service.HibernateBasicCrudServices;

@Path("/basics")
public class HibernateBasicCrudResources {

	@Autowired
	HibernateBasicCrudServices hibernateBasicCrudServices;


	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {

		List<User> users = hibernateBasicCrudServices.getAllUsers();

		return Response.ok().status(200).entity(users).build();
	}

	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id) {

		User user = hibernateBasicCrudServices.getUser(id);
		return Response.ok().status(200).entity(user).build();
	}

	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user, @Context UriInfo uriInfo) {

		Long id = (long) hibernateBasicCrudServices.add(user);
		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@PUT
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, User user, @Context UriInfo uriInfo) {

		hibernateBasicCrudServices.update(id, user);
		
		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	
		
	}

	@DELETE
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {

		hibernateBasicCrudServices.delete(id);
		return Response.ok().status(200).entity("{\"status\": \" deleted\"}").build();
	}
}
