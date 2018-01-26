package com.jersey.spring.hibernate.server.resource;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Path("/addresses/sort")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sort(@DefaultValue("")@QueryParam("city_asc") String sortCity,
							@DefaultValue("")@QueryParam("pincode_asc") String sortPincode) {
	
		List<Address> address = addressRepository.getAllAddress();
		
		return Response.ok().status(200).entity(address).build();
	}
	
	@GET
	@Path("/addresses/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@DefaultValue("")@QueryParam("city_asc") String sortCity,
							@DefaultValue("")@QueryParam("pincode_asc") String sortPincode) {
	
		List<Address> address = addressRepository.getAllAddress();
		
		return Response.ok().status(200).entity(address).build();
	}
	
	@GET
	@Path("/addresses/condition")
	@Produces(MediaType.APPLICATION_JSON)
	public Response filter(@DefaultValue("")@QueryParam("city_name") String cityNameLike,
							@DefaultValue("")@QueryParam("country_name") String countryName,
							@DefaultValue("")@QueryParam("range1") String range1,
							@DefaultValue("")@QueryParam("range2") String range2) {
		
		Map<String, String> conditions = new HashMap<>();
		
		conditions.put("city_name", cityNameLike);
		conditions.put("country_name", countryName);
		conditions.put("range1", range1);
		conditions.put("range2", range2);
		
		List<Address> address = addressRepository.findBy(conditions);
		
		return Response.ok().status(200).entity(address).build();
	}
	
	
	@GET
	@Path("/addresses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAddress() {
	
		List<Address> address = addressRepository.getAllAddress();
		
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
