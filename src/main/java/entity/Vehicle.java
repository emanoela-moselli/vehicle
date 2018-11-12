package main.java.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Vehicle {

	@Id
	private Long vin;
	private Long registration;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnoreProperties("vehicles")
	private Owner owner;
	
	public Vehicle (){}
	
	public Vehicle (Long vin, Long registration, Owner owner){
		this.vin = vin;
		this.registration = registration;
		this.owner = owner;
	}
	
	public Long getVin() {
		return vin;
	}
	
	public void setVin(Long vin) {
		this.vin = vin;
	}
	
	public Long getRegistration() {
		return registration;
	}
	
	public void setRegistration(Long registration) {
		this.registration = registration;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((registration == null) ? 0 : registration.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (registration == null) {
			if (other.registration != null)
				return false;
		} else if (!registration.equals(other.registration))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", registration=" + registration + ", owner=" + owner + "]";
	}

}
