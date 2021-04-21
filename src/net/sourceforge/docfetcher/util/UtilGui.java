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

package net.sourceforge.docfetcher.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import net.sourceforge.docfetcher.enums.Msg;
import net.sourceforge.docfetcher.enums.SettingsConf;
import net.sourceforge.docfetcher.enums.SettingsConf.FontDescription;
import net.sourceforge.docfetcher.gui.ManualLocator;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;
import net.sourceforge.docfetcher.util.annotations.VisibleForPackageGroup;
import net.sourceforge.docfetcher.util.gui.Col;
import net.sourceforge.docfetcher.util.gui.dialog.InfoDialog;

/**
 * @author Tran Nam Quang
 */
@VisibleForPackageGroup
public final class UtilGui {
	
	/**
	 * Default minimum value for the width of a button.
	 */
	public static final int BTW = 75;
	@Nullable private static KeyListener selectAllKeyListener;

	private UtilGui() {
	}
	
	public static final int DIALOG_STYLE = SWT.PRIMARY_MODAL | SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX | SWT.RESIZE;
	
	/**
	 * Returns whether the system currently seems to use a dark theme.
	 */
	public static boolean isDarkTheme() {
		Color col = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		return !isMoreWhite(col);
	}
	
	/**
	 * Returns whether the perceived brigthness of the given color is closer to
	 * white than to black.
	 */
	public static boolean isMoreWhite(Color col) {
		int r = col.getRed();
		int g = col.getGreen();
		int b = col.getBlue();
		return (0.299 * r + 0.587 * g + 0.114 * b) / 255 > 0.5;
	}
	
	/**
	 * Sets the background of the given control to the given SWT color constant.
	 */
	public static void setBackground(Control control, int colInt) {
		control.setBackground(control.getDisplay().getSystemColor(colInt));
	}
	
	/**
	 * Sets the foreground of the given control to the given SWT color constant.
	 */
	public static void setForeground(Control control, int colInt) {
		control.setForeground(control.getDisplay().getSystemColor(colInt));
	}
	
	/**
	 * Sets the foreground of the given link to the given SWT color constant.
	 */
	public static void setLinkForeground(Link link, int colInt) {
		link.setLinkForeground(link.getDisplay().getSystemColor(colInt));
	}

	/**
	 * Returns a suitable text foreground color for the given background color.
	 * The returned color is either black or white, depending on the perceived
	 * luminance of the given background color.
	 */
	@NotNull
	public static Color getTextForeground(@NotNull Color background) {
		return isMoreWhite(background) ? Col.BLACK.get() : Col.WHITE.get();
	}
	
	/**
	 * Returns either <tt>SWT.COLOR_BLACK</tt> or <tt>SWT.COLOR_WHITE</tt>,
	 * depending on whether black or white would be a more readable text
	 * foreground color on the given color as the background color.
	 */
	public static int getTextForegroundInt(Color col) {
		return isMoreWhite(col) ? SWT.COLOR_BLACK : SWT.COLOR_WHITE;
	}
	
	/**
	 * Sets the foreground color of the given control to either black or white
	 * depending on the perceived brightness of the control's background color.
	 */
	public static void setForegroundFromBackground(Control control) {
		Color bgCol = control.getBackground();
		int fgColInt = getTextForegroundInt(bgCol);
		setForeground(control, fgColInt);
	}
	
	/**
	 * Paints a border around the given Control. This can be used as a
	 * replacement for the ugly native border of Composites with SWT.BORDER
	 * style on Windows with classic theme turned on.
	 */
	public static void paintBorder(final Control control) {
		control.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Point size = control.getSize();
				e.gc.setForeground(Col.WIDGET_NORMAL_SHADOW.get());
				e.gc.drawRectangle(0, 0, size.x - 1, size.y - 1);
				e.gc.setForeground(Col.WIDGET_LIGHT_SHADOW.get());
				e.gc.drawRectangle(1, 1, size.x - 3, size.y - 3);
			}
		});
	}
	
	/**
	 * Paints a border around the given Control. This can be used as a
	 * replacement for the ugly native border of Composites with SWT.BORDER
	 * style on Windows with classic theme turned on.
	 * <p>
	 * The individual pieces of the border can be included or omitted by
	 * overriding the <tt>isBorderVisible</tt> method.
	 */
	public static class PaintBorder {
		public PaintBorder(final Control control) {
			control.addPaintListener(new PaintListener() {
				public void paintControl(PaintEvent e) {
					Point size = control.getSize();
					boolean top = isBorderVisible(SWT.TOP);
					boolean bottom = isBorderVisible(SWT.BOTTOM);
					boolean left = isBorderVisible(SWT.LEFT);
					boolean right = isBorderVisible(SWT.RIGHT);
					e.gc.setForeground(Col.WIDGET_NORMAL_SHADOW.get());
					drawLines(e.gc, size, 0, -1, top, bottom, left, right);
					e.gc.setForeground(Col.WIDGET_LIGHT_SHADOW.get());
					drawLines(e.gc, size, 1, -2, top, bottom, left, right);
				}
			});
		}

		/**
		 * Returns whether the border on the given side is visible (i.e., should
		 * be drawn). The given side can be <tt>SWT.TOP</tt>,
		 * <tt>SWT.BOTTOM</tt>, <tt>SWT.LEFT</tt> or <tt>SWT.RIGHT</tt>.
		 */
		protected boolean isBorderVisible(int side) {
			return true;
		}
	}
	
	/**
	 * Attaches a focus listener to the given StyledText that clears the
	 * selection and resets the caret position when the StyledText looses focus.
	 */
	public static void clearSelectionOnFocusLost(@NotNull final StyledText st) {
		st.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				st.setSelection(0);
			}
		});
	}
	
	/** Hides the caret and the selection in the given StyledText. */
	public static void hideCaretAndSelection(@NotNull StyledText st) {
		st.setCaret(null);
		st.setEditable(false);
		st.setCursor(st.getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
		st.setSelectionBackground(st.getBackground());
		st.setSelectionForeground(st.getForeground());
	}
	
	public static void setGridData(	@NotNull Control control,
									boolean grabExcessVerticalSpace) {
		control.setLayoutData(new GridData(
			SWT.FILL, SWT.FILL, true, grabExcessVerticalSpace));
	}
	
	public static void showOutOfMemoryMessage(	@NotNull final Control control,
												@NotNull CheckedOutOfMemoryError e) {
		showOutOfMemoryMessage(control, e.getCause());
	}
	
	public static void showOutOfMemoryMessage(	@NotNull final Control control,
												@NotNull Throwable t) {
		Util.printErr(t);
		UtilGui.runSwtSafe(control, new Runnable() {
			public void run() {
				String url = ManualLocator.getManualSubpageUrl("Memory_Limit.html");
				if (url == null) {
					url = "???";
				}
				
				// Note: getShell() must be called in the SWT thread
				InfoDialog dialog = new InfoDialog(control.getShell());
				dialog.setTitle(Msg.out_of_memory.get());
				dialog.setImage(SWT.ICON_ERROR);
				dialog.setText(Msg.out_of_memory_instructions.format(url));
				dialog.open();
			}
		});
	}
	
	@NotNull
	public static FontDescription getPreviewFontNormal() {
		if (Util.IS_WINDOWS)
			return SettingsConf.FontDescription.PreviewWindows;
		if (Util.IS_LINUX)
			return SettingsConf.FontDescription.PreviewLinux;
		if (Util.IS_MAC_OS_X)
			return SettingsConf.FontDescription.PreviewMacOsX;
		throw new IllegalStateException();
	}
	
	@NotNull
	public static FontDescription getPreviewFontMono() {
		if (Util.IS_WINDOWS)
			return SettingsConf.FontDescription.PreviewMonoWindows;
		if (Util.IS_LINUX)
			return SettingsConf.FontDescription.PreviewMonoLinux;
		if (Util.IS_MAC_OS_X)
			return SettingsConf.FontDescription.PreviewMonoMacOsX;
		throw new IllegalStateException();
	}

	/**
	 * Returns a string representing the key combination, e.g. "CTRL + H".
	 */
	@NotNull
	public static String toString(@NotNull int[] hotkey) {
		int stateMask = hotkey[0];
		int keyCode = hotkey[1];
		boolean ctrl = (stateMask & SWT.CTRL) != 0;
		boolean shift = (stateMask & SWT.SHIFT) != 0;
		boolean alt = (stateMask & SWT.ALT) != 0;
		String key = "";
		
		switch (keyCode) {
		case SWT.F1: key = Msg.f1.get(); break;
		case SWT.F2: key = Msg.f2.get(); break;
		case SWT.F3: key = Msg.f3.get(); break;
		case SWT.F4: key = Msg.f4.get(); break;
		case SWT.F5: key = Msg.f5.get(); break;
		case SWT.F6: key = Msg.f6.get(); break;
		case SWT.F7: key = Msg.f7.get(); break;
		case SWT.F8: key = Msg.f8.get(); break;
		case SWT.F9: key = Msg.f9.get(); break;
		case SWT.F10: key = Msg.f10.get(); break;
		case SWT.F11: key = Msg.f11.get(); break;
		case SWT.F12: key = Msg.f12.get(); break;
		case SWT.PAUSE: key = Msg.pause_key.get(); break;
		case SWT.PRINT_SCREEN: key = Msg.print_screen_key.get(); break;
		case SWT.BS: key = Msg.backspace_key.get(); break;
		case SWT.CR: key = Msg.enter_key.get(); break;
		case SWT.INSERT: key = Msg.insert_key.get(); break;
		case SWT.DEL: key = Msg.delete_key.get(); break;
		case SWT.HOME: key = Msg.home_key.get(); break;
		case SWT.END: key = Msg.end_key.get(); break;
		case SWT.PAGE_UP: key = Msg.page_up_key.get(); break;
		case SWT.PAGE_DOWN: key = Msg.page_down_key.get(); break;
		case SWT.ARROW_UP: key = Msg.arrow_up.get(); break;
		case SWT.ARROW_DOWN: key = Msg.arrow_down.get(); break;
		case SWT.ARROW_LEFT: key = Msg.arrow_left.get(); break;
		case SWT.ARROW_RIGHT: key = Msg.arrow_right.get(); break;
		default: {
			key = String.valueOf((char) keyCode).toUpperCase();
		}
		}
		
		if (alt) key = Msg.alt_key.get() + " + " + key;
		if (shift) key = Msg.shift_key.get() + " + " + key;
		if (ctrl) key = Msg.ctrl_key.get() + " + " + key;
		return key;
	}
	
	private static void drawLines(GC gc, Point size, int m1, int m2,
			boolean top, boolean bottom, boolean left, boolean right) {
		if (top) {
			gc.drawLine(m1, m1, size.x + m2, m1);
		}
		if (bottom) {
			gc.drawLine(m1, size.y + m2, size.x + m2, size.y + m2);
		}
		if (left) {
			gc.drawLine(m1, m1, m1, size.y + m2);
		}
		if (right) {
			gc.drawLine(size.x + m2, m1, size.x + m2, size.y + m2);
		}
	}

	/**
	 * Centers the given shell relative to its parent shell and sets the shell's
	 * width and height. If there is no parent shell, the given shell is
	 * centered relative to the screen.
	 */
	public static void setCenteredBounds(	@NotNull Shell shell,
											int width,
											int height) {
		shell.setSize(width, height);
		Composite parent = shell.getParent();
		Rectangle parentBounds = null;
		if (parent == null || !parent.isVisible())
			parentBounds = shell.getMonitor().getBounds();
		else
			parentBounds = parent.getBounds();
		int shellPosX = (parentBounds.width - width) / 2;
		int shellPosY = (parentBounds.height - height) / 2;
		if (parent != null) {
			shellPosX += parentBounds.x;
			shellPosY += parentBounds.y;
		}
		shell.setLocation(shellPosX, shellPosY);
	}

	/**
	 * Packs the given shell and then centers it relative to its parent shell.
	 * If there is no parent shell, the given shell is centered relative to the
	 * screen.
	 */
	public static void setCenteredBounds(@NotNull Shell shell) {
		shell.pack();
		Point shellSize = shell.getSize();
		Composite parent = shell.getParent();
		Rectangle parentBounds = null;
		if (parent == null || !parent.isVisible())
			parentBounds = shell.getMonitor().getBounds();
		else
			parentBounds = parent.getBounds();
		int shellPosX = (parentBounds.width - shellSize.x) / 2;
		int shellPosY = (parentBounds.height - shellSize.y) / 2;
		if (parent != null) {
			shellPosX += parentBounds.x;
			shellPosY += parentBounds.y;
		}
		shell.setLocation(shellPosX, shellPosY);
	}

	/**
	 * Packs the given shell and then centers it relative to the given control.
	 */
	public static void setCenteredBounds(	@NotNull Shell shell,
											@NotNull Control control) {
		shell.pack();
		Point shellSize = shell.getSize();
		Composite parent = control.getParent();
		Rectangle bounds = control.getBounds();
		bounds = control.getDisplay().map(parent, null, bounds);
		int x = bounds.x + (bounds.width - shellSize.x) / 2;
		int y = bounds.y + (bounds.height - shellSize.y)/ 2;
		shell.setLocation(x, y);
	}

	/**
	 * Centers the given shell relative to its parent shell and sets the shell's
	 * minimum width and height. The actual width and height may be greater to
	 * provide enough space for the shell's children. If the given shell has no
	 * parent shell, it is centered relative to the screen.
	 */
	public static void setCenteredMinBounds(@NotNull Shell shell,
											int minWidth,
											int minHeight) {
		Point prefSize = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		int width = Math.max(prefSize.x, minWidth);
		int height = Math.max(prefSize.y, minHeight);
		setCenteredBounds(shell, width, height);
	}

	@NotNull
	public static Button[] maybeSwapButtons(@NotNull Button b1,
											@NotNull Button b2) {
		boolean leftAlign = b1.getDisplay().getDismissalAlignment() == SWT.LEFT;
		return new Button[] { leftAlign ? b1 : b2, leftAlign ? b2 : b1 };
	}

	/**
	 * Returns whether the first bit mask contains the second bit mask.
	 * <p>
	 * Example: {@code contains(SWT.CTRL | SWT.ALT, SWT.CTRL) == true}
	 */
	public static boolean contains(int bit1, int bit2) {
		return (bit1 & bit2) == bit2;
	}

	/**
	 * Creates and returns a {@link org.eclipse.swt.layout.FillLayout
	 * FillLayout} with the given margin.
	 */
	public static FillLayout createFillLayout(int margin) {
		FillLayout layout = new FillLayout();
		layout.marginWidth = layout.marginHeight = margin;
		return layout;
	}

	/**
	 * Creates and returns a {@link org.eclipse.swt.layout.GridLayout
	 * GridLayout} with the given arguments.
	 */
	public static GridLayout createGridLayout(int numColumns, boolean makeColumsEqualWidth, int margin, int spacing) {
		GridLayout layout = new GridLayout(numColumns, makeColumsEqualWidth);
		layout.marginWidth = layout.marginHeight = margin;
		layout.horizontalSpacing = layout.verticalSpacing = spacing;
		return layout;
	}

	/**
	 * Creates and returns a {@link org.eclipse.swt.layout.FormLayout
	 * FormLayout} with the given margin.
	 */
	public static FormLayout createFormLayout(int margin) {
		FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = margin;
		return layout;
	}

	@NotNull
	public static Text createLabeledGridText(	@NotNull Composite parent,
												@NotNull String labelText) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		Text text = new Text(parent, SWT.BORDER | SWT.SINGLE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return text;
	}

	@NotNull
	public static Text createUnlabeledGridText(	@NotNull Composite parent) {
		Text text = new Text(parent, SWT.BORDER | SWT.SINGLE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return text;
	}

	@NotNull
	public static StyledText createLabeledGridStyledText(	@NotNull Composite parent,
															@NotNull String labelText) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		StyledText text = new StyledText(parent, SWT.BORDER | SWT.SINGLE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return text;
	}

	@NotNull
	public static Button createCheckButton(	@NotNull Composite parent,
											@NotNull String label) {
		Button bt = new Button(parent, SWT.CHECK);
		bt.setText(label);
		return bt;
	}

	@NotNull
	public static Button createPushButton(	@NotNull Composite parent,
											@NotNull String label,
											@NotNull SelectionListener listener) {
		Button bt = new Button(parent, SWT.PUSH);
		bt.setText(label);
		bt.addSelectionListener(listener);
		return bt;
	}

	@NotNull
	public static Button createPushButton(	@NotNull Composite parent,
											@Nullable Image image,
											@Nullable String toolTip,
											@NotNull SelectionListener listener) {
		Button bt = new Button(parent, SWT.PUSH);
		bt.setImage(image);
		if (toolTip != null)
			bt.setToolTipText(toolTip);
		bt.addSelectionListener(listener);
		return bt;
	}

	public static void assertSwtThread() {
		if (Display.getCurrent() == null)
			throw new IllegalStateException();
	}

	/**
	 * Runs the given {@code Runnable} in a way that avoids throwing errors of
	 * the type {@link SWT#ERROR_THREAD_INVALID_ACCESS}. This is useful for
	 * running GUI-accessing code from non-GUI threads.
	 * <p>
	 * The given Runnable is <b>not</b> run if the given given widget is null or
	 * disposed. This helps avoid the common pitfall of trying to access widgets
	 * from a non-GUI thread when these widgets have already been disposed.
	 * <p>
	 * The returned Boolean indicates whether the Runnable was run (true) or not
	 * (false).
	 */
	public static boolean runSwtSafe(	@Nullable final Widget widget,
										@NotNull final Runnable runnable) {
		if (Display.getCurrent() != null) {
			boolean wasRun = widget != null && !widget.isDisposed();
			if (wasRun)
				runnable.run();
			return wasRun;
		}
		else {
			return UtilGui.runSyncExec(widget, runnable);
		}
	}
	
	/**
	 * @see UtilGui#runSwtSafe(Widget, Runnable)
	 */
	public static boolean runSwtSafe(	@Nullable final Display display,
										@NotNull final Runnable runnable) {
		if (Display.getCurrent() != null) {
			boolean wasRun = display != null && !display.isDisposed();
			if (wasRun)
				runnable.run();
			return wasRun;
		}
		else {
			return runSyncExec(display, runnable);
		}
	}

	/**
	 * Runs the given {@code Runnable} via {@link Display#syncExec(Runnable)}.
	 * This is useful for running GUI-accessing code from non-GUI threads.
	 * <p>
	 * The given Runnable is <b>not</b> run if the given given widget is null or
	 * disposed. This helps avoid the common pitfall of trying to access widgets
	 * from a non-GUI thread when these widgets have already been disposed.
	 * <p>
	 * The returned Boolean indicates whether the Runnable was run (true) or not
	 * (false).
	 */
	public static boolean runSyncExec(	@Nullable final Widget widget,
										@NotNull final Runnable runnable) {
		if (widget == null || widget.isDisposed())
			return false;
		final boolean[] wasRun = { false };
		widget.getDisplay().syncExec(new Runnable() {
			public void run() {
				wasRun[0] = !widget.isDisposed();
				if (wasRun[0])
					runnable.run();
			}
		});
		return wasRun[0];
	}

	/**
	 * @see #runSyncExec(Widget, Runnable)
	 */
	public static boolean runSyncExec(	@Nullable final Display display,
										@NotNull final Runnable runnable) {
		if (display == null || display.isDisposed())
			return false;
		final boolean[] wasRun = { false };
		display.syncExec(new Runnable() {
			public void run() {
				wasRun[0] = !display.isDisposed();
				if (wasRun[0])
					runnable.run();
			}
		});
		return wasRun[0];
	}

	/**
	 * Runs the given {@code Runnable} via {@link Display#asyncExec(Runnable)}.
	 * This is useful for running GUI-accessing code from non-GUI threads.
	 * <p>
	 * The given Runnable is <b>not</b> run if the given widget is null or
	 * disposed. This helps avoid the common pitfall of trying to access widgets
	 * from a non-GUI thread when these widgets have already been disposed.
	 */
	public static void runAsyncExec(@Nullable final Widget widget,
									@NotNull final Runnable runnable) {
		/*
		 * Note: Unlike the syncExec variant, here it's not possible to return a
		 * boolean flag that indicates whether the Runnable was run, since
		 * asyncExec may not execute the Runnable immediately.
		 */
		if (widget == null || widget.isDisposed())
			return;
		widget.getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (!widget.isDisposed())
					runnable.run();
			}
		});
	}
	
	/**
	 * Runs the given {@code Runnable} via {@link Display#asyncExec(Runnable)}.
	 * This is useful for running GUI-accessing code from non-GUI threads.
	 * <p>
	 * The given Runnable is <b>not</b> run if the given display is null or
	 * disposed. This helps avoid the common pitfall of trying to access widgets
	 * from a non-GUI thread when these widgets have already been disposed.
	 */
	public static void runAsyncExec(@Nullable final Display display,
									@NotNull final Runnable runnable) {
		/*
		 * Note: Unlike the syncExec variant, here it's not possible to return a
		 * boolean flag that indicates whether the Runnable was run, since
		 * asyncExec may not execute the Runnable immediately.
		 */
		if (display == null || display.isDisposed())
			return;
		display.asyncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					runnable.run();
			}
		});
	}

	/**
	 * Launches the given filename or filepath, and returns whether the file was
	 * successfully launched. This method first tries to launch the file via the
	 * SWT method {@link Program#launch(String)}. If this fails and the
	 * application is running on Linux, this method tries to call xdg-open.
	 */
	public static boolean launch(@NotNull String filename) {
		Util.checkNotNull(filename);
		
		/*
		 * Program.launch fails on Kubuntu 16.04 but still returns true, so we
		 * will have to bypass it altogether. See:
		 * https://sourceforge.net/p/docfetcher/discussion/702424/thread/37481456e9/
		 */
		if (Util.IS_LINUX_KDE)
			return launchXdgOpen(filename);
		
		if (Program.launch(filename))
			return true;
		
		if (!Util.IS_LINUX)
			return false;
		
		return launchXdgOpen(filename);
	}

	/**
	 * @see #launch(String)
	 */
	public static boolean launch(@NotNull File fileOrDir) {
		Util.checkNotNull(fileOrDir);
		return launch(Util.getSystemAbsPath(fileOrDir));
	}
	
	private static boolean launchXdgOpen(@NotNull String filename) {
		try {
			String[] cmd = {"xdg-open", filename};
			Process process = Runtime.getRuntime().exec(cmd);
			int exitValue = process.waitFor();
			return exitValue == 0;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * Applying this method to the given widget will cause all the text in it to
	 * become selected if the user clicks on it after coming back from another
	 * part of the GUI or another program. The widget must be a Combo or a Text
	 * widget.
	 */
	public static void selectAllOnFocus(@NotNull final Control text) {
		Util.checkThat(text instanceof Combo || text instanceof Text || text instanceof StyledText);
	
		class SelectAllOnFocus extends MouseAdapter implements FocusListener {
			private boolean focusGained = false;
			public void focusGained(FocusEvent e) {
				focusGained = true;
			}
			public void focusLost(FocusEvent e) {
			}
			public void mouseDown(MouseEvent e) {
				if (! focusGained) return;
				if (text instanceof Combo)
					UtilGui.selectAll((Combo) text);
				else if (text instanceof Text)
					((Text) text).selectAll();
				else if (text instanceof StyledText)
					((StyledText) text).selectAll();
				focusGained = false;
			}
		}
	
		SelectAllOnFocus listener = new SelectAllOnFocus();
		text.addFocusListener(listener);
		text.addMouseListener(listener);
	}

	public static void registerSelectAllKey(@NotNull final StyledText st) {
		if (selectAllKeyListener == null) {
			selectAllKeyListener = new KeyAdapter() {
				public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
					if (e.stateMask == SWT.MOD1 || e.keyCode == 'a')
						st.selectAll();
				}
			};
		}
		st.addKeyListener(selectAllKeyListener);
	}

	/**
	 * Selects all the text in the given combo.
	 */
	public static void selectAll(@NotNull Combo combo) {
		int length = combo.getText().length();
		combo.setSelection(new Point(0, length));
	}

	/**
	 * Returns an array of files from the system clipboard, or null if there are
	 * no files on the clipboard. This method should not be called from a
	 * non-GUI thread, and it should not be called before an SWT display has
	 * been created.
	 */
	@Nullable
	public static List<File> getFilesFromClipboard() {
		assertSwtThread();
		Clipboard clipboard = new Clipboard(Display.getDefault());
		try {
			TransferData[] types = clipboard.getAvailableTypes();
			for (TransferData type : types) {
				if (!FileTransfer.getInstance().isSupportedType(type))
					continue;
	
				Object data = clipboard.getContents(FileTransfer.getInstance());
				if (data == null || !(data instanceof String[]))
					continue;
	
				String[] paths = (String[]) data;
				List<File> files = new ArrayList<File>(paths.length);
				for (String path : paths)
					files.add(new File(path));
				return files;
			}
			return null;
		}
		finally {
			clipboard.dispose();
		}
	}

	public static void setClipboard(@NotNull String text) {
		Util.checkNotNull(text);
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		clipboard.setContents(new Object[] {text}, types);
		clipboard.dispose();
	}

	/**
	 * Replaces the contents of the given clipboard with the given text and
	 * returns the clipboard. If the given clipboard is null, it will be
	 * created. This will only work if an SWT Display has been created.
	 */
	public static void setClipboard(@NotNull Collection<File> files) {
		Util.checkNotNull(files);
		if (files.isEmpty())
			return;
	
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		Transfer[] types = new Transfer[] {
				TextTransfer.getInstance(),
				FileTransfer.getInstance()
		};
	
		StringBuilder sb = new StringBuilder();
		String[] filePaths = new String[files.size()];
		int i = 0;
		for (File file : files) {
			if (i != 0)
				sb.append("\n");
			String path = Util.getSystemAbsPath(file);
			sb.append(path);
			filePaths[i] = path;
			i++;
		}
	
		clipboard.setContents(new Object[] {sb.toString(), filePaths}, types);
		clipboard.dispose();
	}

	/**
	 * Adds a {@link MouseTrackListener} to the given control that highlights
	 * the background when the mouse hovers over the control.
	 */
	public static void addMouseHighlighter(@NotNull final Control control) {
		control.addMouseTrackListener(new MouseTrackAdapter() {
			public void mouseEnter(MouseEvent e) {
				control.setBackground(Col.WIDGET_HIGHLIGHT_SHADOW.get());
			}
			public void mouseExit(MouseEvent e) {
				control.setBackground(null);
			}
		});
	}

	/**
	 * Returns whether the given key code represents the Enter key, which can be
	 * either the 'normal' Enter key or the Enter key on the numpad.
	 */
	public static boolean isEnterKey(int keyCode){
		return keyCode == SWT.CR || keyCode == SWT.KEYPAD_CR;
	}

	/**
	 * Returns whether the given keyCode is a character or a number.
	 */
	public static boolean isAlphaNumeric(int keyCode){
		return (keyCode >=97 && keyCode <=122) || (keyCode >=48 && keyCode <=57);
	}

	// Any of the given resources may be null
	public static void disposeWith(	@NotNull Widget widget,
									@NotNull final Resource... resources) {
		Util.checkNotNull(widget, resources);
		widget.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				for (Resource resource : resources)
					if (resource != null)
						resource.dispose();
			}
		});
	}
	
}
