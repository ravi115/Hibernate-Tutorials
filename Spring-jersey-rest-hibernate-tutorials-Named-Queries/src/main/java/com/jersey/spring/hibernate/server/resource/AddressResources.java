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

import com.jersey.spring.hibernate.server.model.Address;
import com.jersey.spring.hibernate.server.repository.AddressRepository;

@Path("/named/query")
public class AddressResources {

	@Autowired
	AddressRepository addressRepository;
	
	@GET
	@Path("/addresses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAddress() {
	
		List<Address> address = addressRepository.getAllAddress();
		
		return Response.ok().status(200).entity(address).build();
	}
	
	
	@GET
	@Path("/addresses/sql")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAddressUsingSQL() {
		
		List<Address> address = addressRepository.getAllAddressUsingSQL();
		
		return Response.ok().status(200).entity(address).build();
	}
	
	@GET
	@Path("/addresses/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getAddress(@PathParam("id") int id) {
		
		Address address = addressRepository.getAdddress(id);
		
		return Response.ok().status(200).entity(address).build();
	}
	
	
	@POST
	@Path("/addresses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Address address, @Context UriInfo uriInfo) {
		
		Long id = (long) addressRepository.add(address);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		
		return Response.ok().status(200).entity(uri).build();
	}
}
