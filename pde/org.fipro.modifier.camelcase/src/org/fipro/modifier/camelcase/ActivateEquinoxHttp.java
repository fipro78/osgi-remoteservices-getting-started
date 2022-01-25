package org.fipro.modifier.camelcase;

import java.util.Arrays;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * This class is used to ensure that the Equinox HttpService and HttpWhiteboard
 * bundles are started when using the bnd launcher. The reason is that those
 * bundles have <code>Bundle-ActivationPolicy: lazy</code> set. As nobody
 * actually requests the services provided by those bundles, they are stuck in
 * the <i>STARTING</i> state. This immediate component activates those bundlesl
 */
@Component(immediate = true)
public class ActivateEquinoxHttp {

	@Activate
	void activate(BundleContext context) {
		Arrays.stream(context.getBundles())
			.filter(b ->  
				b.getSymbolicName().contains("equinox.http") 
				&& b.getState() == Bundle.STARTING)
			.forEach(b -> {
				System.out.println("Activate " + b.getSymbolicName());
				try {
					b.start();
				} catch (BundleException e) {
					System.err.println("Failed to activate bundle " + b.getSymbolicName());
				}
			});
	}
}
