package org.fipro.modifier.provider;

import org.fipro.modifier.StringModifier;
import org.osgi.service.component.annotations.Component;

@Component
public class StringModifierImpl implements StringModifier {

	@Override
	public String modify(String input) {
		return new StringBuilder(input).reverse().toString();
	}
}
