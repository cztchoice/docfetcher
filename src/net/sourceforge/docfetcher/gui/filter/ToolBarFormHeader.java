/*******************************************************************************
 * Copyright (c) 2010, 2011 Tran Nam Quang.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tran Nam Quang - initial API and implementation
 *******************************************************************************/

package net.sourceforge.docfetcher.gui.filter;

import net.sourceforge.docfetcher.gui.CustomBorderComposite;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.UtilGui;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * Note: Subclassers can override <tt>isBorderVisible</tt> to change the
 * visibility of the borders.
 */
class ToolBarFormHeader extends CustomBorderComposite {
	
	private final Label imageLabel;
	private final Label textLabel;
	@Nullable private final Composite toolBar;
	
	public ToolBarFormHeader(Composite parent) {
		super(parent);
		GridLayout gridLayout = UtilGui.createGridLayout(3, false, 3, 5);
		gridLayout.marginLeft = 3;
		setLayout(gridLayout);
		
		// verticalIndent + 1 on Windows due to bottom border not being drawn
		
		imageLabel = new Label(this, SWT.NONE);
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd.verticalIndent = Util.IS_WINDOWS ? 1 : 0;
		imageLabel.setLayoutData(gd);
		
		textLabel = new Label(this, SWT.NONE);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd.verticalIndent = Util.IS_WINDOWS ? 1 : 0;
		textLabel.setLayoutData(gd);
		
		// margin=1 for the fill layout to leave room for the custom border
		toolBar = new Composite(this, SWT.NONE);
		toolBar.setLayout(UtilGui.createFillLayout(1));
		createToolBar(toolBar);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		updateLayout();
	}
	
	private void updateLayout() {
		int colCount = 1;
		GridData imageData = (GridData) imageLabel.getLayoutData();
		if (imageLabel.getImage() == null) {
			imageData.exclude = true;
		} else {
			imageData.exclude = false;
			colCount++;
		}
		if (toolBar != null)
			colCount++;
		((GridLayout) getLayout()).numColumns = colCount;
		layout();
	}
	
	@Nullable
	public final Image getImage() {
		return imageLabel.getImage();
	}

	public final void setImage(@Nullable Image image) {
		imageLabel.setImage(image);
		updateLayout();
	}

	@NotNull
	public final String getText() {
		return textLabel.getText();
	}

	public final void setText(@NotNull String text) {
		textLabel.setText(text);
	}

	@Nullable
	protected Control createToolBar(Composite parent) {
		return null;
	}

}
