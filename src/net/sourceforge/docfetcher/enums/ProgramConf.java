/*******************************************************************************
 * Copyright (c) 2010 Tran Nam Quang.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tran Nam Quang - initial API and implementation
 *******************************************************************************/

package net.sourceforge.docfetcher.enums;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.primitives.Ints;

import net.sourceforge.docfetcher.util.ConfLoader.Storable;
import net.sourceforge.docfetcher.util.Util;
import net.sourceforge.docfetcher.util.annotations.Immutable;

/**
 * This class handles the retrieval of application-wide, <em>unmodifiable</em>
 * preferences and allows type safe access to them via nested enums. The default
 * values of the preferences are hardcoded so as to avoid program corruption
 * caused by manipulation of the preferences file by users.
 * <p>
 * New preferences entries can be added by adding enum members to the nested
 * enums. CamelCase names are to be preferred to UPPERCASE names since the
 * former make the preferences file more readable. Duplicate names (e.g.
 * Conf.Bool.Test and Conf.Int.Test) are not supported and should be avoided.
 * <p>
 * New enums (not enum <em>members</em>) must implement the
 * <code>Pref.Loadable</code> interface; everything else is handled
 * automatically via reflection.
 *
 * @author Tran Nam Quang
 */
public final class ProgramConf {

	// TODO pre-release: remove unused entries
	// TODO pre-release: reset entries whose values where changed for development purposes (e.g. fix window sizes)

	public static enum Bool implements Storable {
		CheckSingleInstance (true),
		FixWindowSizes (false),
		DryRun (false),
		AllowIndexCreation (true),
		AllowIndexUpdate (true),
		AllowIndexRenaming (true),
		AllowIndexRebuild (true),
		AllowIndexDeletion (true),
		ShowAdvancedSettingsLink (true),
		ReportObsoleteIndexFiles (true),
		IndexExcelFormulas (true),
		SkipTarArchives (false),
		IgnoreJunctionsAndSymlinks (true),
		SaveSettings (true),
		TextPreviewEnabled (true),
		PdfPreviewVisualOrder (true),
		PythonApiEnabled (false),
		ShowPathsDuringIndexing (false),
		WriteIndexingLog (false),
		HotkeyEnabled (false),
		;

		private boolean value;
		Bool(boolean value) {
			this.value = value;
		}
		public boolean get() {
			return value;
		}
		public void load(String str) {
			value = Boolean.parseBoolean(str);
		}
		public String valueToString() {
			return Boolean.toString(value);
		}
	}

	public static enum Int implements Storable {
		SearchHistorySize (20, 1),
		MaxLinesInProgressPanel (1000, 2),
		SearchBoxMaxWidth (500, 0),
		MaxResultsTotal (10000, 1),
		OpenLimit (10, 1),
		PatternTableHeight (4, 1),
		UnpackCacheCapacity (20, 1),
		InitialSorting (0),
		PythonApiPort (28834),
		;

		private int value;
		private final int min;
		private final int max;

		Int(int value, int min, int max) {
			this.value = value;
			this.min = min;
			this.max = max;
		}
		Int(int value, int min) {
			this(value, min, Integer.MAX_VALUE);
		}
		Int(int value) {
			this(value, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public int get() {
			return value;
		}
		public void load(String str) {
			value = Util.clamp(Util.toInt(str, value), min, max);
		}
		public String valueToString() {
			return Integer.toString(value);
		}
	}

	public static enum Str implements Storable {
		AppName ("DocFetcher"),
		TextEncodingOverride (""),
		;

		private String value;
		Str(String value) {
			this.value = value;
		}
		public String get() {
			return value;
		}
		public void load(String str) {
			value = str;
		}
		public File getFile() {
			return new File(value);
		}
		public String valueToString() {
			return value;
		}
	}

	public static enum IntArray implements Storable {
		;

		private int[] value;
		IntArray(int... value) {
			this.value = value;
		}
		public int[] get() {
			return value;
		}
		public void load(String str) {
			value = Util.toIntArray(str, value);
		}
		public String valueToString() {
			return Ints.join(", ", value);
		}
	}

	public static enum StrList implements Storable {
		HtmlExtensions ("html", "htm", "xhtml", "shtml", "shtm")
		;

		private List<String> value;
		StrList(String... value) {
			this.value = Arrays.asList(value);
		}
		@Immutable
		public List<String> get() {
			return Collections.unmodifiableList(value);
		}
		public void load(String str) {
			value = Util.decodeStrings(';', str);
		}
		public String valueToString() {
			return Util.encodeStrings(";", value);
		}
	}

	private ProgramConf () {}

}
