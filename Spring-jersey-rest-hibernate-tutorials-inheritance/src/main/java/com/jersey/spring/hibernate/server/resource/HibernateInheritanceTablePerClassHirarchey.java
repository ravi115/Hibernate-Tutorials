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

import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Animal;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Cat;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Dog;
import com.jersey.spring.hibernate.server.repository.TablePerClassHirarchey;

@Path("/inheritance/TablePerHirarchey")
public class HibernateInheritanceTablePerClassHirarchey {

	@Autowired
	TablePerClassHirarchey tablePerClassHirarchey;
	
	@GET
	@Path("/animals")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAnimals() {
		
		List<Animal> animals = tablePerClassHirarchey.getAllAnimals();
		return Response.ok().status(200).entity(animals).build();
	}
	
	@GET
	@Path("/animals/cat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCat() {
		
		List<Cat> cat = tablePerClassHirarchey.getAllCat();
		return Response.ok().status(200).entity(cat).build();
	}
	
	@GET
	@Path("/animals/dog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDogs() {
		
		List<Dog> dog = tablePerClassHirarchey.getAllDog();
		return Response.ok().status(200).entity(dog).build();
	}
	
	@GET
	@Path("/animals/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnimals(@PathParam("id") int id) {
		
		Animal animals = tablePerClassHirarchey.getAnimal(id);
		return Response.ok().status(200).entity(animals).build();
	}
	
	@GET
	@Path("/animals/cat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCat(@PathParam("id") int id) {
		
		Cat cat = tablePerClassHirarchey.getCat(id);
		return Response.ok().status(200).entity(cat).build();
	}
	
	@GET
	@Path("/animals/dog/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDog(@PathParam("id") int id) {
		
		Dog dog = tablePerClassHirarchey.getDog(id);
		return Response.ok().status(200).entity(dog).build();
	}
	
	@POST
	@Path("/animals/cat")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCat(Cat cat, @Context UriInfo uriInfo) {
		
		long id = (long) tablePerClassHirarchey.add(cat);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		
		return Response.ok().status(201).entity(uri).build();
	}
	
	@POST
	@Path("/animals/dog")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDog(Dog dog, @Context UriInfo uriInfo) {
		
		long id = (long) tablePerClassHirarchey.add(dog);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		
		return Response.ok().status(201).entity(uri).build();
	}
}
