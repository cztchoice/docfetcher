/*******************************************************************************
 * Copyright (c) 2011 Tran Nam Quang.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tran Nam Quang - initial API and implementation
 *******************************************************************************/

package net.sourceforge.docfetcher.util.gui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

import net.sourceforge.docfetcher.util.AppUtil;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.UtilGui;
import net.sourceforge.docfetcher.util.annotations.NotNull;

/**
 * @author Tran Nam Quang
 */
public class InfoDialog {
	
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		FillLayout layout = new FillLayout();
		layout.marginWidth = layout.marginHeight = 5;
		shell.setLayout(layout);
		Button bt = new Button(shell, SWT.PUSH);
		bt.setText("Open Dialog");
		bt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				InfoDialog dialog = new InfoDialog(shell);
				dialog.setTitle("Title");
				dialog.setText("You can click this <a href=\"https://www.google.com\">link</a>.");
				dialog.open();
			}
		});
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				UtilGui.setCenteredBounds(shell, 200, 150);
			}
		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	private final Shell shell;
	private final Label icon;
	private final Link label;
	private final Button bt;
	
	public InfoDialog(@NotNull Shell parent) {
		Util.checkNotNull(parent);
		shell = new Shell(parent, SWT.PRIMARY_MODAL | SWT.DIALOG_TRIM);
		
		icon = new Label(shell, SWT.NONE);
		icon.setImage(shell.getDisplay().getSystemImage(SWT.ICON_INFORMATION));
		
		label = new Link(shell, SWT.NONE);
		label.setBackground(icon.getBackground());
		label.setForeground(icon.getForeground()); // Not necessary
		
		label.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				UtilGui.launch(e.text);
			}
		});
		
		bt = new Button(shell, SWT.PUSH);
		bt.setText(AppUtil.Messages.ok.get());
		bt.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		
		shell.setLayout(UtilGui.createGridLayout(2, false, 10, 15));
		icon.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
		GridData labelGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		labelGridData.widthHint = 300;
		label.setLayoutData(labelGridData);
		
		GridData btGridData = new GridData(SWT.CENTER, SWT.FILL, true, false, 2, 1);
		btGridData.minimumWidth = UtilGui.BTW;
		bt.setLayoutData(btGridData);
	}
	
	public void setTitle(@NotNull String title) {
		Util.checkNotNull(title);
		shell.setText(title);
	}
	
	public void setImage(@NotNull Image image) {
		Util.checkNotNull(image);
		icon.setImage(image);
	}
	
	public void setImage(int swtImage) {
		icon.setImage(shell.getDisplay().getSystemImage(swtImage));
	}
	
	// Supports hyperlinks
	public void setText(@NotNull String text) {
		Util.checkNotNull(text);
		label.setText(text);
	}
	
	public void open() {
		UtilGui.setCenteredBounds(shell);
		bt.setFocus(); // Avoid focusing hyperlinks if there are any
		shell.open();
		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch())
				shell.getDisplay().sleep();
		}
	}

}
