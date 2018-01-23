package com.jersey.spring.hibernate.server.resource;

import java.net.URI;
import java.util.ArrayList;
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

import com.jersey.spring.hibernate.model.bd.onetomany.Author;
import com.jersey.spring.hibernate.model.bd.onetomany.Books;
import com.jersey.spring.hibernate.server.repository.HibernateOneToManyBDRespository;
import com.jersey.spring.hibernate.server.repository.HibernateOneToManyBDRespositoryImpl;
import com.jersey.spring.hibernate.server.service.HibernateOneToManyBDServices;

@Path("/OneToMany/bidirectional")
public class HibernateOneToManyBDResources {

	@Autowired
	HibernateOneToManyBDServices hibernateOneToManyBDServices;

	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAuthor() {

		List<Author> authors = hibernateOneToManyBDServices.getAllAuthor();

		return Response.ok().status(200).entity(authors).build();
	}

	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {

		List<Books> books = hibernateOneToManyBDServices.getAllBooks();

		return Response.ok().status(200).entity(books).build();
	}

	@GET
	@Path("/authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAuthor(@PathParam("id") int id) {

		Author author = hibernateOneToManyBDServices.getAuthor(id);

		return Response.ok().status(200).entity(author).build();
	}

	@GET
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") int id) {

		Books books = hibernateOneToManyBDServices.getBooks(id);

		return Response.ok().status(200).entity(books).build();
	}

	@POST
	@Path("/authors")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(Author author, @Context UriInfo uriInfo ) {

		long id = hibernateOneToManyBDServices.add(author);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}

	@POST
	@Path("/books")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBooks(Books books, @Context UriInfo uriInfo) {

		long id = hibernateOneToManyBDServices.add(books);

		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(201).entity(createdUri).build();
	}
	
	@PUT
	@Path("/authors/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfessor(@PathParam("id") int id, Author author, @Context UriInfo uriInfo) {

		hibernateOneToManyBDServices.update(id, author);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@PUT
	@Path("/books/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBooks(@PathParam("id") int id, Books Books, @Context UriInfo uriInfo) {

		hibernateOneToManyBDServices.update(id, Books);

		return Response.ok().status(200).entity(uriInfo.getAbsolutePath()).build();
	}
	
	@DELETE
	@Path("/authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProfessor(@PathParam("id") int id) {

		hibernateOneToManyBDServices.deleteAuthor(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}

	@DELETE
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProfessorDetail(@PathParam("id") int id) {

		hibernateOneToManyBDServices.deleteBooks(id);

		return Response.ok().status(200).entity("{\"status\" : \"deleted\"}").build();
	}
}
