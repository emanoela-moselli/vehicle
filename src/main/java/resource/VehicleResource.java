package main.java.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.java.dao.VehicleDAO;
import main.java.entity.Owner;
import main.java.entity.Vehicle;

@Path("/vehicle")
public class VehicleResource {
	
	@EJB
	VehicleDAO vehicleDAO;

	public VehicleResource() {
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVehicle(Vehicle vehicle) {
		try {
			vehicleDAO.save(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			
		}
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVehicles() {
		List<Vehicle> vehicles = vehicleDAO.listAll();
		if(vehicles != null){
			return Response.ok(vehicles).build();	
		} 
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ownerName}")
	public Response getByOwner(@PathParam("ownerName") String ownerName) {
		List<Vehicle> vehicles = vehicleDAO.findByOwner(new Owner(ownerName));
		if(vehicles != null){
			return Response.ok(vehicles).build();	
		} 
		return Response.status(Status.NOT_FOUND).build();
	}
}
