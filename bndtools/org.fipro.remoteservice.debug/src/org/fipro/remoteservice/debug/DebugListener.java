package org.fipro.remoteservice.debug;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.remoteserviceadmin.RemoteServiceAdminListener;
import org.eclipse.ecf.osgi.services.remoteserviceadmin.DebugRemoteServiceAdminListener;

@Component
public class DebugListener
    extends DebugRemoteServiceAdminListener
    implements RemoteServiceAdminListener {
	// register the DebugRemoteServiceAdminListener via DS
}