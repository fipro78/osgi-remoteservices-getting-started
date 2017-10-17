package org.fipro.ds.remote.debug;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

/**
 * The Remote Service Admin needs to fire events via EventAdmin additionally to informing 
 * RemoteServiceAdminListener. This way it is possible to register only for an explicit event.
 */
@Component(property = EventConstants.EVENT_TOPIC + "=org/osgi/service/remoteserviceadmin/*")
public class RemoteServiceEventListener implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println(event.getTopic());
		for (String objectClass :  ((String[])event.getProperty("objectClass"))) {
			System.out.println("\t"+objectClass);
		}
	}

}
