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

package net.sourceforge.docfetcher.gui.preview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import net.sourceforge.docfetcher.enums.Img;
import net.sourceforge.docfetcher.enums.Msg;
import net.sourceforge.docfetcher.enums.SettingsConf;
import net.sourceforge.docfetcher.model.search.HighlightedString;
import net.sourceforge.docfetcher.model.search.Range;
import net.sourceforge.docfetcher.util.Event;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.UtilGui;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;
import net.sourceforge.docfetcher.util.gui.ContextMenuManager;
import net.sourceforge.docfetcher.util.gui.MenuAction;

/**
 * @author Tran Nam Quang
 */
final class HighlightingText {
	
	private static final int margin = 10;
	
	@NotNull private StyledText textViewer;
	@NotNull private Color highlightColor;
	@NotNull private StyleRange highlightStyle;
	
	private int[] highlightSpans = new int[0]; // start-end pairs
	private Map<Integer, int[]> lineIndexToSpans = new HashMap<>(); // start-end pairs
	
	private int lineNumbersWidth = 0;
	private Bullet lineNumbersBullet = null;
	
	private Font normalFont;
	private Font monoFont;
	private boolean useMonoFont = true;
	
	public HighlightingText(@NotNull Composite parent) {
		int style = SWT.FULL_SELECTION | SWT.READ_ONLY | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL | SWT.BORDER;
		textViewer = new StyledText(parent, style);
		textViewer.setMargins(margin, margin, margin, margin);
		textViewer.setContent(new AppendingStyledTextContent());
		textViewer.addLineStyleListener(new LineStyleListener() {
			@Override
			public void lineGetStyle(LineStyleEvent event) {
				handleLineStyleEvent(event);
			}
		});
		setHighlightColorAndStyle();
		
		StyleRange bulletStyle = new StyleRange();
		bulletStyle.metrics = new GlyphMetrics(0, 0, lineNumbersWidth);
		bulletStyle.foreground = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
		lineNumbersBullet = new Bullet(ST.BULLET_NUMBER | ST.BULLET_TEXT, bulletStyle);
		
		// Update highlight color when preferences entry changes
		SettingsConf.IntArray.PreviewHighlighting.evtChanged.add(new Event.Listener<int[]>() {
			public void update(int[] eventData) {
				final Color oldColor = highlightColor;
				setHighlightColorAndStyle();
				textViewer.redraw();
				/*
				 * The StyledText widget will update its style asynchronously
				 * and for some reason must access the old color while doing so.
				 * Thus, the following asyncExec is needed; otherwise StyledText
				 * will try to access a disposed color and throw an exception.
				 */
				UtilGui.runAsyncExec(textViewer, new Runnable() {
					@Override
					public void run() {
						oldColor.dispose();
					}
				});
			}
		});
		
		// Update normal font when preferences entry changes
		UtilGui.getPreviewFontNormal().evtChanged.add(new Event.Listener<Void>() {
			public void update(Void eventData) {
				if (normalFont == null)
					return;
				Font oldFont = normalFont;
				normalFont = UtilGui.getPreviewFontNormal().createFont();
				if (textViewer.getFont() == oldFont)
					textViewer.setFont(normalFont);
				oldFont.dispose();
				updateLineNumbersCache();
				textViewer.redraw();
			}
		});
		
		// Update monospace font when preferences entry changes
		UtilGui.getPreviewFontMono().evtChanged.add(new Event.Listener<Void>() {
			public void update(Void eventData) {
				if (monoFont == null)
					return;
				Font oldFont = monoFont;
				monoFont = UtilGui.getPreviewFontMono().createFont();
				if (textViewer.getFont() == oldFont)
					textViewer.setFont(monoFont);
				oldFont.dispose();
				updateLineNumbersCache();
				textViewer.redraw();
			}
		});
		
		// Dispose of fonts and highlight color
		textViewer.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				Resource[] resources = new Resource[] {
					normalFont, monoFont, highlightColor };
				for (Resource resource : resources)
					if (resource != null)
						resource.dispose();
			}
		});
		
		// Context menu
		ContextMenuManager menuManager = new ContextMenuManager(textViewer);
		String label = Util.IS_MAC_OS_X ? Msg.copy_macosx.get() : Msg.copy.get();
		menuManager.add(new MenuAction(Img.CLIPBOARD.get(), label) {
			public void run() {
				textViewer.invokeAction(ST.COPY);
			}
		});
	}
	
	private void setHighlightColorAndStyle() {
		int[] rgb = SettingsConf.IntArray.PreviewHighlighting.get();
		highlightColor = new Color(textViewer.getDisplay(), rgb[0], rgb[1], rgb[2]);
		highlightStyle = new StyleRange(0, 0, null, highlightColor);
	}
	
	@NotNull
	public StyledText getControl() {
		return textViewer;
	}
	
	public void redraw() {
		textViewer.redraw();
	}
	
	public void setText(@NotNull HighlightedString string) {
		if (string.isEmpty()) {
			highlightSpans = new int[0];
			lineIndexToSpans.clear();
		} else {
			List<Range> ranges = string.getRanges();
			highlightSpans = new int[ranges.size() * 2];
			for (int i = 0; i < ranges.size(); i++) {
				int start = ranges.get(i).start;
				highlightSpans[i * 2] = start;
				highlightSpans[i * 2 + 1] = start + ranges.get(i).length;
			}
			lineIndexToSpans = Util.createLineMap(string.getString(), highlightSpans);
		}
		textViewer.setText(string.getString());
		updateLineNumbersCache();
		textViewer.redraw();
	}
	
	public void clear() {
		textViewer.setText("");
		highlightSpans = new int[0];
		lineIndexToSpans.clear();
		updateLineNumbersCache();
		textViewer.redraw();
	}
	
	public void setUseMonoFont(boolean useMonoFont) {
		this.useMonoFont = useMonoFont;
		if (useMonoFont) {
			if (monoFont == null)
				monoFont = UtilGui.getPreviewFontMono().createFont();
			textViewer.setFont(monoFont);
		}
		else {
			if (normalFont == null)
				normalFont = UtilGui.getPreviewFontNormal().createFont();
			textViewer.setFont(normalFont);
		}
		updateLineNumbersCache();
		textViewer.redraw();
	}

	/**
	 * Selects and scrolls to the nearest occurrence, if one exists, starting
	 * from the current selection. If <tt>forward</tt> is true, this method goes
	 * to the next occurrence, otherwise to the previous one.
	 * <p>
	 * This method returns the number of the occurrence that was scrolled to.
	 * The number is 1-based and relative to the occurrences in the receiver. If
	 * no occurrence was found, null is returned.
	 */
	@Nullable
	public Integer goTo(boolean forward) {
		Point sel = textViewer.getSelection();
		int searchStart = forward ? sel.y : sel.x;
		return goTo(forward, searchStart);
	}
	
	/**
	 * Selects and scrolls to the last occurrence, if one exists.
	 * <p>
	 * This method returns the number of the occurrence that was scrolled to.
	 * The number is 1-based and relative to the occurrences in the receiver. If
	 * no occurrence was found, null is returned.
	 */
	@Nullable
	public Integer goToLast() {
		return goTo(false, textViewer.getCharCount());
	}
	
	// argument is one-based
	public void goTo(int occ) {
		int i = occ - 1;
		if (i < 0 || i >= highlightSpans.length / 2) {
			return;
		}
		int start = highlightSpans[i * 2];
		int end = highlightSpans[i * 2 + 1];
		selectAndShowSpan(start, end);
	}
	
	// returns one-based occurrence index, or null
	@Nullable
	private Integer goTo(boolean forward, int searchStart) {
		if (forward) {
			for (int i = 0; i < highlightSpans.length / 2; i++) {
				int start = highlightSpans[i * 2];
				if (start >= searchStart) {
					int end = highlightSpans[i * 2 + 1];
					selectAndShowSpan(start, end);
					return i + 1;
				}
			}
		} else {
			int i = highlightSpans.length / 2 - 1;
			while (i >= 0) {
				int end = highlightSpans[i * 2 + 1];
				if (end <= searchStart) {
					int start = highlightSpans[i * 2];
					selectAndShowSpan(start, end);
					return i + 1;
				}
				i--;
			}
		}
		return null;
	}
	
	private void selectAndShowSpan(int start, int end) {
		textViewer.setSelection(start, end);
		scrollToMiddle((start + end) / 2);
	}
	
	/**
	 * Vertically divides the text viewer into three segments of equal height
	 * and scrolls the given caret offset into view so that it is always
	 * displayed in the middle segment (either at the top or at bottom of it or
	 * somewhere in between).
	 */
	private void scrollToMiddle(int caretOffset) {
		try {
			/*
			 * Note: Some lines may be wrapped, so it's possible that
			 * linePixelNow != lineHeight * lineNumber.
			 */
			int linePixelTop = textViewer.getTopPixel();
			int linePixelNow = textViewer.getLocationAtOffset(caretOffset).y + linePixelTop - margin;
			int linePixelBottom = linePixelTop + textViewer.getClientArea().height;
			int dist = linePixelBottom - linePixelTop;
			int dist13 = dist / 3;
			int dist23 = 2 * dist / 3;
			double lineIndexMiddleTop = linePixelTop + dist / 3;
			double lineIndexMiddleBottom = linePixelBottom - dist / 3;
			if (linePixelNow < lineIndexMiddleTop)
				textViewer.setTopPixel(linePixelNow - dist13);
			else if (linePixelNow > lineIndexMiddleBottom)
				textViewer.setTopPixel(linePixelNow - dist23);
		}
		catch (Exception e) {
			// Ignore invalid caret offset
		}
	}
	
	private void updateLineNumbersCache() {
		int indent = 8; // line number indent in pixels
		String gap = " "; // gap between line number and line text
		
		GC gc = new GC(textViewer);
		int width = indent + gc.stringExtent(textViewer.getLineCount() + gap).x;
		gc.dispose();
		
		StyleRange style = new StyleRange();
		style.metrics = new GlyphMetrics(0, 0, width);
		style.foreground = textViewer.getDisplay().getSystemColor(SWT.COLOR_GRAY);
		
		Bullet bullet = new Bullet(ST.BULLET_NUMBER | ST.BULLET_TEXT, style);
		bullet.text = gap;
		
		lineNumbersWidth = width;
		lineNumbersBullet = bullet;
	}
	
	private void handleLineStyleEvent(LineStyleEvent e) {
		int lineIndex = textViewer.getLineAtOffset(e.lineOffset);
		if (SettingsConf.Bool.HighlightingEnabled.get()) {
			int[] spans = lineIndexToSpans.get(lineIndex);
			if (spans != null) {
				e.ranges = new int[spans.length];
				e.styles = new StyleRange[spans.length / 2];
				for (int i = 0; i < spans.length / 2; i++) {
					int start = spans[i * 2];
					e.ranges[i * 2] = start;
					e.ranges[i * 2 + 1] = spans[i * 2 + 1] - start;
					e.styles[i] = highlightStyle;
				}
			}
		}
		
		/*
		 * If there's no text, don't show the line number, otherwise the latter
		 * will make it look as if there's text.
		 */
		if (useMonoFont && textViewer.getCharCount() > 0) {
			e.bulletIndex = lineIndex;
			e.bullet = lineNumbersBullet;
			e.wrapIndent = lineNumbersWidth;
		}
	}

}
