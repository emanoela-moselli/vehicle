
# vehicle

## Description
RESTful API for add vehicle and owner

## Technologies:
JAX-RS

JavaEE

JPA

EJB

H2 Database


## Availables services:

###### Add Vehicle
**Path:**  http://localhost:8080/vehicleAPI/api/vehicle

**Method:** POST

**Example:** 
```
{
	"vin":555,
	"registration":555,
	"owner":{
	"name":"Peter"
	}
}
```
###### Get Vehicles
**Path:**  http://localhost:8080/vehicleAPI/api/vehicle

**Method:** GET

###### Get Owners
**Path:**  http://localhost:8080/vehicleAPI/api/owner

**Method:** GET

###### GET Vehicles from Owner
**Path:**  http://localhost:8080/vehicleAPI/api/vehicle/{ownerName}

**Method:** GET

