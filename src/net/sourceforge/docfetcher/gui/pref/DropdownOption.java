/*******************************************************************************
 * Copyright (c) 2018 Tran Nam Quang.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tran Nam Quang - initial API and implementation
 *******************************************************************************/

package net.sourceforge.docfetcher.gui.pref;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import net.sourceforge.docfetcher.enums.SettingsConf;
import net.sourceforge.docfetcher.gui.pref.PrefDialog.PrefOption;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;

/**
 * @author Tran Nam Quang
 */
final class DropdownOption extends PrefOption {
	
	@NotNull private SettingsConf.Int enumOption;
	@NotNull private CCombo dropdown;
	@NotNull private String[] choices;
	@NotNull private int[] choiceIndices;
	
	public DropdownOption(	@NotNull String labelText,
							@NotNull SettingsConf.Int enumOption,
							@NotNull String[] choices,
							@Nullable int[] choiceIndices) { // internal mapping from choice strings to numbers
		super(labelText);
		this.enumOption = enumOption;
		this.choices = choices;
		if (choiceIndices == null) {
			choiceIndices = new int[choices.length];
			for (int i = 0; i < choices.length; i++) {
				choiceIndices[i] = i;
			}
		}
		this.choiceIndices = choiceIndices;
	}

	@Override
	protected void createControls(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		int style = SWT.BORDER | SWT.READ_ONLY | SWT.FLAT;
		dropdown = new CCombo(parent, style);
		dropdown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dropdown.setCursor(dropdown.getDisplay().getSystemCursor(SWT.CURSOR_HAND));
		dropdown.setItems(choices);
		dropdown.setText(getChoice(enumOption.get()));
	}

	@Override
	protected void restoreDefault() {
		dropdown.setText(getChoice(enumOption.get()));
	}

	@Override
	protected void save() {
		for (int i = 0; i < choices.length; i++) {
			if (choices[i].equals(dropdown.getText())) {
				enumOption.set(choiceIndices[i]);
				return;
			}
		}
	}
	
	@NotNull
	private String getChoice(int index) {
		for (int i = 0; i < choiceIndices.length; i++) {
			if (choiceIndices[i] == index) {
				return choices[i];
			}
		}
		throw new IllegalArgumentException();
	}

}
