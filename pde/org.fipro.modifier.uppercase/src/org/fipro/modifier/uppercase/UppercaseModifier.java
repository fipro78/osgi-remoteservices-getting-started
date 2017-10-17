package org.fipro.modifier.uppercase;

import java.util.Locale;

import org.fipro.modifier.StringModifier;
import org.osgi.service.component.annotations.Component;

@Component(
	property= {
		"service.exported.interfaces=*",
		"service.exported.configs=ecf.generic.server"
	}
)
public class UppercaseModifier implements StringModifier {

	@Override
	public String modify(String input) {
		return input.toUpperCase(Locale.getDefault());
	}
	
}