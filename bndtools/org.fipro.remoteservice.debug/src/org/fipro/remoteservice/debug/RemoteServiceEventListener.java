package org.fipro.remoteservice.debug;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

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