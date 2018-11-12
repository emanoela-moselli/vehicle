package main.java.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Owner;
import main.java.entity.Vehicle;

@Stateless
public class VehicleDAO {

	@PersistenceContext(unitName="vehiclePU")
	private EntityManager em;

	public void save(Vehicle vehicle) throws Exception{
		em.persist(vehicle);
	}

	 public List<Vehicle> listAll(){
		 return em.createQuery("SELECT v from Vehicle v JOIN FETCH v.owner ").getResultList();
	 }
	 
	 public List<Vehicle> findByOwner(Owner owner){
		 return em.createQuery("SELECT v from Vehicle v JOIN FETCH v.owner WHERE v.owner =:_owner").setParameter("_owner", owner).getResultList();
	 }
}
