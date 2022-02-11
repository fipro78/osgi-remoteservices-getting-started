package org.fipro.modifier.inverter;

import org.fipro.modifier.api.StringModifier;
import org.osgi.service.component.annotations.Component;

@Component(property= {
    "service.exported.interfaces=*",
    "service.exported.configs=ecf.generic.server" }
)
public class StringInverter implements StringModifier {

    @Override
    public String modify(String input) {
        return (input != null)
        		? new StringBuilder(input).reverse().toString()
        		: "No input given";
    }
}