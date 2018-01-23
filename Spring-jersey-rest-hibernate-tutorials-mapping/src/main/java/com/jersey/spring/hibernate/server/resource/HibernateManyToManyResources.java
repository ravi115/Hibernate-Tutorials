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

import com.jersey.spring.hibernate.model.manytomany.Cycles;
import com.jersey.spring.hibernate.model.manytomany.Stands;
import com.jersey.spring.hibernate.server.service.HibernateManyToManyServices;


@Path("/ManyToMany")
public class HibernateManyToManyResources {

	@Autowired
	HibernateManyToManyServices hibernateManyToManyServices;

	@GET
	@Path("/stands")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStands() {

		List<Stands> stands = hibernateManyToManyServices.getAllStands();

		return Response.ok().status(200).entity(stands).build();
	}

	@GET
	@Path("/cycles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCycles() {

		List<Cycles> cycles = hibernateManyToManyServices.getAllCycles();

		return Response.ok().status(200).entity(cycles).build();
	}

	@GET
	@Path("/stands/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStands(@PathParam("id") int id) {

		Stands Stands = hibernateManyToManyServices.getStands(id);

		return Response.ok().status(200).entity(Stands).build();
	}

	@GET
	@Path("/cycles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCycles(@PathParam("id") int id) {

		Cycles cycles = hibernateManyToManyServices.getCycles(id);

		return Response.ok().status(200).entity(cycles).build();
	}

	@POST
	@Path("/stands")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStands(Stands Stands, @Context UriInfo uriInfo ) {

		long id = hibernateManyToManyServices.add(Stands);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@POST
	@Path("/cycles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCycles(Cycles cycles, @Context UriInfo uriInfo) {

		long id = hibernateManyToManyServices.add(cycles);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}
	
	@PUT
	@Path("/stands/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStands(@PathParam("id") int id, Stands Stands, @Context UriInfo uriInfo) {

		hibernateManyToManyServices.update(id, Stands);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@PUT
	@Path("/cycles/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCycles(@PathParam("id") int id, Cycles cycles, @Context UriInfo uriInfo) {

		hibernateManyToManyServices.update(id, cycles);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@DELETE
	@Path("/stands/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStands(@PathParam("id") int id) {

		hibernateManyToManyServices.deleteStands(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}

	@DELETE
	@Path("/cycles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCycles(@PathParam("id") int id) {

		hibernateManyToManyServices.deleteCycles(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}
}
