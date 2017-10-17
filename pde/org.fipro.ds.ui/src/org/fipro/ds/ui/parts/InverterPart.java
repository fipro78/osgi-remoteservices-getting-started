package org.fipro.ds.ui.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.extensions.Service;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.fipro.modifier.StringModifier;
 
@SuppressWarnings("restriction")
public class InverterPart {

	@Inject
	@Service
	private List<StringModifier> modifierList;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, true));
 
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText("String to modify:");
		GridDataFactory.fillDefaults().applyTo(inputLabel);
 
		final Text input = new Text(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
 
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Modify");
		GridDataFactory.defaultsFor(button).applyTo(button);
 
		Label outputLabel = new Label(parent, SWT.NONE);
		outputLabel.setText("Modified String:");
		GridDataFactory.fillDefaults().applyTo(outputLabel);
 
		final Text output = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(output);
 
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StringBuilder builder = new StringBuilder();
				for (StringModifier modifier : modifierList) {
					builder.append(((StringModifier) modifier).modify(input.getText())).append(System.getProperty("line.separator"));
				}
				output.setText(builder.toString());
			}
		});
 
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR
						|| e.keyCode == SWT.KEYPAD_CR) {
					StringBuilder builder = new StringBuilder();
					for (StringModifier modifier : modifierList) {
						builder.append(((StringModifier) modifier).modify(input.getText())).append(System.getProperty("line.separator"));
					}
					output.setText(builder.toString());
				}
			}
		});
	}

}