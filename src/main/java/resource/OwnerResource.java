package main.java.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.java.dao.OwnerDAO;
import main.java.entity.Owner;

@Path("/owner")
public class OwnerResource {

	@EJB
	OwnerDAO ownerDAO;

	public OwnerResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOwners() {
		List<Owner> owners = ownerDAO.listAll();
		if(owners != null){
			return Response.ok(owners).build();	
		} 
		return Response.status(Status.NOT_FOUND).build();
	}
}