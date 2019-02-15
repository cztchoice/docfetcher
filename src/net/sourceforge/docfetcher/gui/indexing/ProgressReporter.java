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

package net.sourceforge.docfetcher.gui.indexing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import net.sourceforge.docfetcher.enums.Msg;
import net.sourceforge.docfetcher.enums.ProgramConf;
import net.sourceforge.docfetcher.model.TreeNode;
import net.sourceforge.docfetcher.model.index.IndexingError;
import net.sourceforge.docfetcher.model.index.IndexingInfo;
import net.sourceforge.docfetcher.model.index.IndexingReporter;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.annotations.NotNull;
import net.sourceforge.docfetcher.util.annotations.Nullable;

/**
 * @author Tran Nam Quang
 */
final class ProgressReporter extends IndexingReporter {
	
	/*
	 * TODO post-release-1.1: maybe print out some filesize-based info at the end:
	 * - file throughput (MB/sec, files/sec)
	 * - average filesize
	 * take care when calculating filesizes for HTML pairs!
	 */
	
	// TODO i18n
	
	private final ProgressTable progressTable;
	private final ErrorTable errorTable;
	private long start = 0;
	@Nullable private IndexingInfo lastInfo;
	@Nullable private final File indexDir;
	@Nullable private File logFile;

	public ProgressReporter(@NotNull ProgressPanel progressPanel, @Nullable File indexDir) {
		progressTable = progressPanel.getProgressTable();
		errorTable = progressPanel.getErrorTable();
		this.indexDir = indexDir;
	}
	
	public void setStartTime(long time) {
		start = time;
		
		// This logging code doesn't really belong here, but the program is a huge mess anyway :-|
		if (ProgramConf.Bool.WriteIndexingLog.get() && indexDir != null) {
			logFile = new File(indexDir, "indexing-log.txt");
			logFile.delete();
			try {
				logFile.createNewFile();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setEndTime(long time) {
		String duration = toHumanReadableDuration(time - start);
		String msg = Msg.total_elapsed_time.format(duration);
		progressTable.append(msg);
	}
	
	/**
	 * Converts the given period of time in milliseconds into something more
	 * human-friendly (e.g. "1 h 24 min 3 s").
	 */
	@NotNull
	private static String toHumanReadableDuration(long millis) {
		int secs = (int) (millis / 1000);
		int hrs = secs / 3600;
		secs -= hrs * 3600;
		int mins = secs / 60;
		secs -= mins * 60;
		String ret = ""; //$NON-NLS-1$
		if (hrs != 0)
			ret += hrs + " h"; //$NON-NLS-1$
		if (mins != 0)
			ret += (hrs == 0 ? "" : " ") + mins + " min"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (secs != 0)
			ret += (hrs == 0 && mins == 0 ? "" : " ") + secs + " s"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (ret.equals("")) //$NON-NLS-1$
			return "0 s"; //$NON-NLS-1$
		return ret;
	}
	
	public void info(@NotNull IndexingInfo info) {
		String message = getMessage(info);
		int[] percentage = info.getPercentage();
		if (percentage != null)
			message = String.format("%s [%d/%d]", message, percentage[0], percentage[1]);
		progressTable.append(message);
		lastInfo = info;
		
		if (ProgramConf.Bool.WriteIndexingLog.get() && indexDir != null) {
			try {
				Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(logFile, true), "UTF-8"));
				writer.append(info.getTreeNode().getPath().getPath() + "\r\n");
				writer.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void subInfo(int current, int total) {
		Util.checkThat(lastInfo != null);
		String message = getMessage(lastInfo);
		message = String.format("%s [%d/%d]", message, current, total);
		progressTable.replaceLast(message);
	}
	
	@NotNull
	private String getMessage(@NotNull IndexingInfo info) {
		TreeNode node = info.getTreeNode();
		final String displayName;
		if (ProgramConf.Bool.ShowPathsDuringIndexing.get()) {
			displayName = node.getPath().getPath();
		} else {
			displayName = node.getDisplayName();
		}
		return String.format("%,d\t %s", info.getNumber(), displayName);
	}
	
	public void fail(@NotNull IndexingError error) {
		String displayName = error.getTreeNode().getDisplayName();
		progressTable.append("### " + Msg.error.format(displayName));
		errorTable.addError(error);
		
		if (ProgramConf.Bool.WriteIndexingLog.get() && indexDir != null) {
			try {
				Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(logFile, true), "UTF-8"));
				String line = "FAIL: " + error.getTreeNode().getPath().getPath() + "\r\n";
				line += "  " + error.getLocalizedMessage() + "\r\n";
				writer.append(line);
				writer.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
