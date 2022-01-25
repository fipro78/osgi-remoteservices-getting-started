package org.fipro.ds.ui.edef;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.remoteserviceadmin.EndpointDescription;
import org.osgi.service.remoteserviceadmin.RemoteServiceAdmin;

@Component(service = EdefImport.class)
public class EdefImport {

	@Reference
	RemoteServiceAdmin admin;
	
	public void importService() {
		Map<String, Object> properties = new HashMap<String, Object>();
		
		properties.put("ecf.endpoint.id", "http://localhost:8282/services/camelcase");
		properties.put("ecf.endpoint.id.ns", "ecf.namespace.jaxrs");
		properties.put("ecf.endpoint.ts", 1642489801532l);
		properties.put("ecf.jaxrs.server.pathPrefix", "/camelcase");
		properties.put("ecf.rsvc.id", 1l);
		properties.put("endpoint.framework.uuid", "0");
		properties.put("endpoint.id", "0");
		properties.put("endpoint.package.version.org.fipro.modifier", "1.0.0");
		properties.put("endpoint.service.id", 38l);
		properties.put("objectClass", new String[] { "org.fipro.modifier.StringModifier" });
		properties.put("remote.configs.supported", new String[] { "ecf.jaxrs.jersey.server" });
		properties.put("remote.intents.supported", new String[] { "passByValue", "exactlyOnce", "ordered", "osgi.async", "osgi.private", "osgi.confidential", "jaxrs" });
		properties.put("service.imported", "true");
		properties.put("service.intents", new String[] { "jaxrs" });
		properties.put("service.imported.configs", new String[] { "ecf.jaxrs.jersey.server" });
		
		EndpointDescription desc = new EndpointDescription(properties);
		admin.importService(desc);
	}
}
