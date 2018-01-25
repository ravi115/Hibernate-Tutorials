package com.jersey.spring.hibernate.server.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
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

import com.jersey.spring.hibernate.server.model.tablepereveryclass.ClassRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.JuniorRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.Library;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.School;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.SeniorRoom;
import com.jersey.spring.hibernate.server.repository.TablePerEveryClass;

@Path("/inheritance/TablePerClass")
public class HibernateInheritanceTablePerEveryClass {

	@Autowired
	TablePerEveryClass tablePerEveryClass;

	@GET
	@Path("/school")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSchools() {

		List<School> schools = tablePerEveryClass.getAllSchools();
		return Response.ok().status(200).entity(schools).build();

	}

	@GET
	@Path("/classroom")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllClassRoom() {

		List<ClassRoom> ClassRoom = tablePerEveryClass.getAllClassRoom();
		return Response.ok().status(200).entity(ClassRoom).build();
	}


	@GET
	@Path("/library")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLibrary() {

		List<Library> Library = tablePerEveryClass.getAllLibrary();
		return Response.ok().status(200).entity(Library).build();
	}


	@GET
	@Path("/juniorroom")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJuniorRoom() {

		List<JuniorRoom> JuniorRoom = tablePerEveryClass.getAllJuniorRoom();
		return Response.ok().status(200).entity(JuniorRoom).build();
	}


	@GET
	@Path("/seniorroom")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSeniorRoom(){

		List<SeniorRoom> SeniorRoom = tablePerEveryClass.getAllSeniorRoom();
		return Response.ok().status(200).entity(SeniorRoom).build();
	}


	@GET
	@Path("/school/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSchools(@PathParam("id") int id) {

		School school = tablePerEveryClass.getSchools(id);
		return Response.ok().status(200).entity(school).build();
	}
	@GET
	@Path("/classroom/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClassRoom(@PathParam("id") int id) {

		ClassRoom ClassRoom = tablePerEveryClass.getClassRoom(id);
		return Response.ok().status(200).entity(ClassRoom).build();
	}

	@GET
	@Path("/library/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLibrary(@PathParam("id") int id) {

		Library Library = tablePerEveryClass.getLibrary(id);
		return Response.ok().status(200).entity(Library).build();
	}

	@GET
	@Path("/juniorroom/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJuniorRoom(@PathParam("id") int id) {

		JuniorRoom JuniorRoom = tablePerEveryClass.getJuniorRoom(id);
		return Response.ok().status(200).entity(JuniorRoom).build();
	}

	@GET
	@Path("/seniorroom/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSeniorRoom(@PathParam("id") int id) {

		SeniorRoom SeniorRoom = tablePerEveryClass.getSeniorRoom(id);
		return Response.ok().status(200).entity(SeniorRoom).build();
	}


	@POST
	@Path("/school")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(School school, @Context UriInfo uriInfo ) {

		Long id = (long) tablePerEveryClass.add(school);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();

	}

	@POST
	@Path("/classroom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(ClassRoom classRoom, @Context UriInfo uriInfo) {
		Long id = (long) tablePerEveryClass.add(classRoom);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}

	@POST
	@Path("/library")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Library library, @Context UriInfo uriInfo) {
		Long id = (long) tablePerEveryClass.add(library);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}

	@POST
	@Path("/juniorroom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(JuniorRoom juniorRoom, @Context UriInfo uriInfo) {
		Long id = (long) tablePerEveryClass.add(juniorRoom);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}

	@POST
	@Path("/seniorroom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(SeniorRoom seniorRoom, @Context UriInfo uriInfo) {
		Long id = (long) tablePerEveryClass.add(seniorRoom);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}

}
