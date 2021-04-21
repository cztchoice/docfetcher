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

package net.sourceforge.docfetcher.gui;

import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;

import net.sourceforge.docfetcher.util.Event;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.UtilGui;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;
import net.sourceforge.docfetcher.util.gui.FormDataFactory;

/**
 * A status bar widget consisting of multiple parts with the following
 * properties:
 * <ul>
 * <li>There is one left part and zero or more right parts.
 * <li>All parts have a text label and an optional image.
 * <li>The text labels may contain HTML hyperlinks.
 * <li>The right parts can be shown and hidden.
 * </ul>
 * This class is intended to be subclassed, optionally overriding
 * {@link #createRightParts(StatusBar)}.
 * 
 * @author Tran Nam Quang
 */
public class StatusBar extends Composite {
	
	/**
	 * A part of a status bar.
	 */
	public static final class StatusBarPart {
		public final Event<Void> evtClicked;
		public final Event<Void> evtLinkClicked = new Event<>();
		
		private final StatusBar statusBar;
		private final Composite comp;
		private final CLabel imgLabel;
		private final Link textLabel;
		private boolean isVisible = true;
		
		public StatusBarPart(@NotNull StatusBar statusBar, boolean clickable) {
			Util.checkNotNull(statusBar);
			this.statusBar = statusBar;
			
			comp = new Composite(statusBar, SWT.NONE);
			imgLabel = new CLabel(comp, SWT.NONE);
			textLabel = new Link(comp, SWT.NONE);
			
			GridLayout layout = new GridLayout(2, false);
			layout.marginWidth = layout.marginHeight = 0;
			comp.setLayout(layout);
			imgLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
			textLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
			
			if (clickable) {
				evtClicked = new Event<Void>();
				textLabel.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent e) {
						evtClicked.fire(null);
					}
				});
				UtilGui.addMouseHighlighter(textLabel);
			}
			else {
				evtClicked = null;
			}
			
			textLabel.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					evtLinkClicked.fire(null);
				}
			});
		}
		
		/**
		 * Returns the receiver's underlying SWT control.
		 */
		@NotNull
		public Control getControl() {
			return comp;
		}
		
		/**
		 * Returns whether this part is visible.
		 */
		public boolean isVisible() {
			return isVisible;
		}
		
		/**
		 * Sets the visibility of this part. Invisible parts are excluded from
		 * the layout. This method has no effect if the part is on the left side
		 * of the status bar.
		 */
		public void setVisible(boolean isVisible) {
			if (this.isVisible == isVisible)
				return;
			this.isVisible = isVisible;
			comp.setVisible(isVisible);
			statusBar.updateLayout();
		}
		
		/**
		 * Sets the image and text of this part. The image may be null. The text
		 * may contain HTML hyperlinks.
		 */
		public void setContents(@Nullable Image image, @NotNull String text) {
			Util.checkNotNull(text);
			imgLabel.setImage(image);
			textLabel.setText(text);
			statusBar.updateLayout();
		}
		
		/**
		 * Returns the image displayed on this part, which may be null.
		 */
		@Nullable
		public Image getImage() {
			return imgLabel.getImage();
		}
		
		/**
		 * Returns the text displayed on this part.
		 */
		@NotNull
		public String getText() {
			return textLabel.getText();
		}
		
		/**
		 * Returns a rectangle describing the bounds of the receiver relative to
		 * containing shell, or null if the receiver is not visible.
		 */
		@Nullable
		public Rectangle getBounds() {
			if (!isVisible)
				return null;
			Shell shell = comp.getShell();
			Rectangle bounds = comp.getBounds();
			return shell.getDisplay().map(statusBar, shell, bounds);
		}
	}
	
	private final StatusBarPart leftPart;
	private final List<StatusBarPart> rightParts;
	
	/**
	 * Creates an instance with the given parent.
	 */
	public StatusBar(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FormLayout());
		
		leftPart = new StatusBarPart(this, false);
		rightParts = createRightParts(this);
		Util.checkNotNull(rightParts);
		
		updateLayout();
	}
	
	/**
	 * Returns the left part.
	 */
	public final StatusBarPart getLeftPart() {
		return leftPart;
	}
	
	/**
	 * Returns the right parts.
	 */
	@NotNull
	public final List<StatusBarPart> getRightParts() {
		return Collections.unmodifiableList(rightParts);
	}
	
	/**
	 * Creates and returns the parts to be added on the right side of the status
	 * bar.
	 */
	@NotNull
	protected List<StatusBarPart> createRightParts(@NotNull StatusBar statusBar) {
		return Collections.emptyList();
	}
	
	/**
	 * Updates the layout of the status bar parts.
	 */
	private void updateLayout() {
		if (rightParts == null)
			return; // right parts are in the process of being created
		
		FormDataFactory fdf = FormDataFactory.getInstance();
		fdf.margin(0).top().bottom();
		
		List<StatusBarPart> parts = Lists.reverse(rightParts);
		parts = Util.createList(parts, leftPart);
		
		Control lastControl = null;
		for (StatusBarPart part : parts) {
			if (!part.isVisible) {
				part.getControl().setLayoutData(null);
				continue;
			}
			if (lastControl == null)
				fdf.right();
			else
				fdf.right(lastControl, -20);
			fdf.applyTo(part.getControl());
			lastControl = part.getControl();
		}
		
		assert lastControl == leftPart.getControl();
		fdf.left().applyTo(lastControl);
		
		layout();
	}

}
