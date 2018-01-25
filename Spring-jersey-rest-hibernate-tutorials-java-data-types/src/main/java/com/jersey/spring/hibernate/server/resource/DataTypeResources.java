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

import com.jersey.spring.hibernate.server.model.JavaDataTypesModel;
import com.jersey.spring.hibernate.server.repository.DataTypeRepository;

@Path("/data/type")
public class DataTypeResources {

	
	@Autowired
	DataTypeRepository dataTypeRepository;
	
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDataTypes() {
		
		List<JavaDataTypesModel> list = dataTypeRepository.getAllDataValues();
		
		return Response.ok().status(200).entity(list).build();
	}
	
	
	@GET
	@Path("/info/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataTypes(@PathParam("id") int id) {
		
		JavaDataTypesModel javaDataTypesModel = dataTypeRepository.getDataValues(id);
		return Response.ok().status(200).entity(javaDataTypesModel).build();
	}
	
	
	@POST
	@Path("/info")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(JavaDataTypesModel javaDataTypesModel, @Context UriInfo uriInfo) {
		
		long id = (long )dataTypeRepository.add(javaDataTypesModel);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		
		return Response.ok().status(201).entity(uri).build();
	}
}
