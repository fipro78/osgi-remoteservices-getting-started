package org.fipro.modifier.client;

import java.util.List;

import org.fipro.modifier.api.StringModifier;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    property= {
        "osgi.command.scope:String=fipro",
        "osgi.command.function:String=modify"},
    service=ModifyCommand.class
)
public class ModifyCommand {

    @Reference
    volatile List<StringModifier> modifier;
	
    public void modify(String input) {
        if (modifier.isEmpty()) {
            System.out.println("No StringModifier registered");
        } else {
            modifier.forEach(m -> System.out.println(m.modify(input)));
        }
    }
}