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

import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Laptop;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Mobile;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.OperatingSystem;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Phones;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Tablets;
import com.jersey.spring.hibernate.server.repository.TablePerConcreteClass;

@Path("/inheritance/TablePerConcreteClass")
public class HibernateInheritanceTablePerConcreteClass {

	@Autowired
	TablePerConcreteClass tablePerConcreteClass;

	@GET
	@Path("/operatingSystem")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOperatingSystem() {

		List<OperatingSystem> operatingSystem = tablePerConcreteClass.getAllOperatingSystem();

		return Response.ok().status(200).entity(operatingSystem).build();
	}
	
	@GET
	@Path("/mobiles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMobile() {

		List<Mobile> mobiles = tablePerConcreteClass.getAllMobile();

		return Response.ok().status(200).entity(mobiles).build();
	}


	@GET
	@Path("/laptops")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLaptops() {

		List<Laptop> laptop = tablePerConcreteClass.getAllLaptops();

		return Response.ok().status(200).entity(laptop).build();
	}


	@GET
	@Path("/phones")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPhones() {

		List<Phones> phones = tablePerConcreteClass.getAllPhones();

		return Response.ok().status(200).entity(phones).build();
	}


	@GET
	@Path("/tablets")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTablets() {

		List<Tablets> tablets = tablePerConcreteClass.getAllTablets();

		return Response.ok().status(200).entity(tablets).build();
	}

	@GET
	@Path("/operatingSystem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOperatingSystem(@PathParam("id") int id) {

		OperatingSystem operatingSystem = tablePerConcreteClass.getOperatingSystem(id);
		return Response.ok().status(200).entity(operatingSystem).build();
	}

	@GET
	@Path("/mobiles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMobile(@PathParam("id") int id) {

		Mobile mobile = tablePerConcreteClass.getMobile(id);
		return Response.ok().status(200).entity(mobile).build();
	}


	@GET
	@Path("/laptops/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLaptop(@PathParam("id") int id) {

		Laptop laptop = tablePerConcreteClass.getLaptop(id);
		return Response.ok().status(200).entity(laptop).build();
	}


	@GET
	@Path("/phones/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhone(@PathParam("id") int id) {

		Phones phone = tablePerConcreteClass.getPhone(id);
		return Response.ok().status(200).entity(phone).build();
	}


	@GET
	@Path("/tablets/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTablets(@PathParam("id") int id) {

		Tablets tablet = tablePerConcreteClass.getTablet(id);
		return Response.ok().status(200).entity(tablet).build();
	}

	
	@POST
	@Path("/laptops")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLaptop(Laptop laptop, @Context UriInfo uriInfo) {

		long id = (long) tablePerConcreteClass.add(laptop);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();

		return Response.ok().status(201).entity(uri).build();
	}
	
	@POST
	@Path("/phones")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPhones(Phones phone, @Context UriInfo uriInfo) {

		long id = (long) tablePerConcreteClass.add(phone);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();

		return Response.ok().status(201).entity(uri).build();
	}
	
	@POST
	@Path("/tablets")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTablet(Tablets tablet, @Context UriInfo uriInfo) {

		long id = (long) tablePerConcreteClass.add(tablet);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();

		return Response.ok().status(201).entity(uri).build();
	}
}
