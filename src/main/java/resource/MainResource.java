package main.java.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class MainResource extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(OwnerResource.class);
        classes.add(VehicleResource.class);
        return classes;
    }
}
