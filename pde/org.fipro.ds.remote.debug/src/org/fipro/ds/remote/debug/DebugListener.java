package org.fipro.ds.remote.debug;

import org.eclipse.ecf.osgi.services.remoteserviceadmin.DebugRemoteServiceAdminListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.remoteserviceadmin.RemoteServiceAdminListener;

/**
 * Component that extends {@link DebugRemoteServiceAdminListener} and registers as {@link RemoteServiceAdminListener}
 * to react on events triggered by the Remote Service Admin.
 */
@Component
public class DebugListener extends DebugRemoteServiceAdminListener implements RemoteServiceAdminListener {
	// register the DebugRemoteServiceAdminListener via DS
}
