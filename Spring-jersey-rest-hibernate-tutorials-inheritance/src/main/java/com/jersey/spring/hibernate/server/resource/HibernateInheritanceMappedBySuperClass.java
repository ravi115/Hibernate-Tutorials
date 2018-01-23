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

import com.jersey.spring.hibernate.server.model.mappedBy.ContractEmployee;
import com.jersey.spring.hibernate.server.model.mappedBy.RegularEmployee;
import com.jersey.spring.hibernate.server.repository.MappedBySupperClass;

@Path("/inheritance/mappedBy")
public class HibernateInheritanceMappedBySuperClass {

	@Autowired
	MappedBySupperClass mappedBySupperClass;
	
	@GET
	@Path("/employees/regular")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRegularEmployee() {
		
		List<RegularEmployee> list = mappedBySupperClass.getAllRegularEmployee();
		
		return Response.ok().status(200).entity(list).build();
	}
	
	@GET
	@Path("/employees/regular/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegularEmployee(@PathParam("id") int id) {
		
		RegularEmployee regularEmployee = mappedBySupperClass.getRegularEmployee(id);
		
		return Response.ok().status(200).entity(regularEmployee).build();
	}
	
	@GET
	@Path("/employees/contract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllContractEmployee() {
		
		List<ContractEmployee> list = mappedBySupperClass.getAllContractEmployee();
		
		return Response.ok().status(200).entity(list).build();
	}
	
	@GET
	@Path("/employees/contract/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContractEmployee(@PathParam("id") int id) {
		
		ContractEmployee contractEmployee = mappedBySupperClass.getContractEmployee(id);
		
		return Response.ok().status(200).entity(contractEmployee).build();
	}
	
	@POST
	@Path("/employees/contract")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addContractEmployee(ContractEmployee contractEmployee, @Context UriInfo uriInfo) {
		
		Long id = (long )  mappedBySupperClass.add(contractEmployee);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}
	
	@POST
	@Path("/employees/regular")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRegularEmployee(RegularEmployee regularEmployee, @Context UriInfo uriInfo) {
		
		Long id = (long )  mappedBySupperClass.add(regularEmployee);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(uri).build();
	}
}
