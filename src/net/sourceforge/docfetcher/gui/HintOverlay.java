/*******************************************************************************
 * Copyright (c) 2021 Tran Nam Quang.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tran Nam Quang - initial API and implementation
 *******************************************************************************/

package net.sourceforge.docfetcher.gui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

import net.sourceforge.docfetcher.util.Event;
import net.sourceforge.docfetcher.util.UtilGui;

/**
 * @author Tran Nam Quang
 */
final class HintOverlay {
	
	public final Event<Void> evtLinkClicked = new Event<Void>();
	
	private static RGB bgDark = new RGB(99, 128, 99); // HSV(120, 22, 50)
	private static RGB bgLight = new RGB(200, 255, 200); // HSV(120, 22, 100)
	private static RGB fgLinkDark = new RGB(220, 220, 255);
	
	public final Shell shell;
	private final StyledText textField;
	private final Link link;
	private final List<Color> colors = new ArrayList<>(2);
	
	public HintOverlay(Shell parent, String text, String linkText) {
		shell = new Shell(parent, SWT.NO_TRIM);
		UtilGui.paintBorder(shell);
		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				for (Color color : colors)
					color.dispose();
			}
		});
		
		textField = new StyledText(shell, SWT.WRAP | SWT.READ_ONLY);
		textField.setText(text);
		UtilGui.hideCaretAndSelection(textField);
		
		link = new Link(shell, SWT.NONE);
		link.setText(String.format("<a href=\"\">%s</a>", linkText));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				evtLinkClicked.fire(null);
			}
		});
		
		setColors();
		
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = layout.marginHeight = 10;
		layout.horizontalSpacing = layout.verticalSpacing = 5;
		shell.setLayout(layout);
		
		textField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		link.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}
	
	// Caller needs to set the shell bounds before opening
	public void open() {
		shell.open();
	}
	
	private void setColors() {
		for (Color color : colors)
			color.dispose();
		colors.clear();
		
		Display display = shell.getDisplay();
		boolean isDarkTheme = UtilGui.isDarkTheme();
		
		Color bgCol = new Color(display, isDarkTheme ? bgDark : bgLight);
		colors.add(bgCol);
		shell.setBackground(bgCol);
		textField.setBackground(bgCol);
		UtilGui.setForegroundFromBackground(textField);
		link.setBackground(bgCol);
		
		if (isDarkTheme) {
			Color linkCol = new Color(display, fgLinkDark);
			link.setLinkForeground(linkCol);
			colors.add(linkCol);
		} else {
			UtilGui.setLinkForeground(link, SWT.COLOR_LINK_FOREGROUND);
		}
	}

}
