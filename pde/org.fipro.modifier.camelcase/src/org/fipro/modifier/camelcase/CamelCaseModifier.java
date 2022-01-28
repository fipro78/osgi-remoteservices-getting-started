package org.fipro.modifier.camelcase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fipro.modifier.api.StringModifier;
import org.osgi.service.component.annotations.Component;

@Path("/modify")
@Component(
		immediate = true,
		property = {
				"service.exported.interfaces=*",
				"service.exported.intents=jaxrs",
				"ecf.jaxrs.server.pathPrefix=/camelcase"})
public class CamelCaseModifier implements StringModifier {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{value}")
	@Override
	public String modify(@PathParam("value") String input) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (i % 2 == 0) {
				builder.append(Character.toUpperCase(currentChar));
			} else {
				builder.append(Character.toLowerCase(currentChar));
			}
		} 
		return builder.toString();
	}
}
