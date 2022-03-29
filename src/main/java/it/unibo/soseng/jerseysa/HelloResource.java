package it.unibo.soseng.jerseysa;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@QueryParam("name") String name) {
		return "Hello "+name;
	}
}
