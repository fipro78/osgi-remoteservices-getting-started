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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.fipro.ds.ui.edef.EdefImport;
import org.fipro.modifier.api.StringModifier;
 
public class InverterPart {

	private List<StringModifier> modifierList;

	private Button button;
	private Text input;
	private Text output;
	
	@Service
	@Inject
	EdefImport importer;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, true));
 
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText("String to modify:");
		GridDataFactory.fillDefaults().applyTo(inputLabel);
 
		input = new Text(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
 
		button = new Button(parent, SWT.PUSH);
		button.setText("Modify (" + (modifierList != null ? modifierList.size() : 0) + ")");
		GridDataFactory.defaultsFor(button).applyTo(button);
 
		Label outputLabel = new Label(parent, SWT.NONE);
		outputLabel.setText("Modified String:");
		GridDataFactory.fillDefaults().applyTo(outputLabel);
 
		output = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(output);
 
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				processModification();
			}
		});
 
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR
						|| e.keyCode == SWT.KEYPAD_CR) {
					processModification();
				}
			}
		});
		 
		Button importButton = new Button(parent, SWT.PUSH);
		importButton.setText("Import EDEF");
		GridDataFactory.defaultsFor(importButton).applyTo(importButton);
		importButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				importer.importService();
			}
		});
		
		Button closeImportButton = new Button(parent, SWT.PUSH);
		closeImportButton.setText("Close EDEF");
		GridDataFactory.defaultsFor(closeImportButton).applyTo(closeImportButton);
		closeImportButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				importer.closeImport();
			}
		});
	}

	@Inject
	void setStringModifier(@Service List<StringModifier> modifierList) {
		this.modifierList = modifierList;
		
		if (button != null) {
			Display.getDefault().asyncExec(() -> {
				button.setText("Modify (" + (modifierList != null ? modifierList.size() : 0) + ")");
			});
		}
	}
	
	private void processModification() {
		StringBuilder builder = new StringBuilder();
		for (StringModifier modifier : modifierList) {
			builder.append(((StringModifier) modifier).modify(input.getText())).append(System.getProperty("line.separator"));
		}
		output.setText(builder.toString());
	}
}