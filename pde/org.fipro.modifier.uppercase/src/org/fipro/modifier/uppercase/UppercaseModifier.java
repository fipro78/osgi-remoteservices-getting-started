package org.fipro.modifier.uppercase;

import java.util.Locale;

import org.fipro.modifier.api.StringModifier;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//The JAX-RS path annotation for this service
@Path("/modify")
//The OSGi DS component annotation
@Component(
    immediate = true,
    property = { 
        "service.exported.interfaces=*",
        "service.exported.configs=ecf.jaxrs.jersey.server", 
        "service.exported.intents=jaxrs",
        "ecf.jaxrs.server.pathPrefix=/upper"})
public class UppercaseModifier implements StringModifier {

    @GET
    // The JAX-RS annotation to specify that JSON is produced
    @Produces(MediaType.APPLICATION_JSON)
    // The JAX-RS annotation to specify that the last part
    // of the URL is used as method parameter
    @Path("/{value}")
    @Override
    public String modify(@PathParam("value") String input) {
        return input.toUpperCase(Locale.getDefault());
    }
}