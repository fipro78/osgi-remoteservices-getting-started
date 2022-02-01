package org.fipro.modifier.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/modify")
public interface StringModifier {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{value}")
    String modify(@PathParam("value") String input);
}