package main.java.resource;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import main.java.dao.VehicleDAO;
import main.java.entity.Owner;
import main.java.entity.Vehicle;

@Singleton
@Startup
@DependsOn("VehicleDAO")
public class StartupResource {

	@EJB
	private VehicleDAO vehicleDao;

	@PostConstruct
	private void startup()  {
		try{
			Owner ownerEmanoela = new Owner("Emanoela");
			vehicleDao.save(new Vehicle(111l,1111l,ownerEmanoela));
			vehicleDao.save(new Vehicle(222l,222l,ownerEmanoela));
			vehicleDao.save(new Vehicle(333l,333l,new Owner("Patrick")));
			vehicleDao.save(new Vehicle(444l,444l,new Owner("Anna")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
