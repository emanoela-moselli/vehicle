package main.java.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Owner;

@Stateless
public class OwnerDAO {

    @PersistenceContext(unitName="vehiclePU")
    private EntityManager em;
    
    public OwnerDAO() {
    }
	
	 public List<Owner> listAll(){
		 return em.createQuery("SELECT distinct o from Owner o JOIN FETCH o.vehicles ").getResultList();
	 }
	
}
