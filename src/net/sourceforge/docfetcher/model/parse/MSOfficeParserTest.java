package net.sourceforge.docfetcher.model.parse;

import java.io.File;

import org.junit.Test;

import junit.framework.Assert;
import net.sourceforge.docfetcher.TestFiles;
import net.sourceforge.docfetcher.model.Cancelable;
import net.sourceforge.docfetcher.model.Path;
import net.sourceforge.docfetcher.model.index.IndexingConfig;
import net.sourceforge.docfetcher.model.index.IndexingReporter;

public class MSOfficeParserTest {

	
	@Test
	public void testParse() throws Exception {
		File file = TestFiles.doc.get();
		long lengthBefore = file.length();
		long modBefore = file.lastModified();
		ParseService.parse(new IndexingConfig(), file, file.getName(),
			new Path(file), IndexingReporter.nullReporter, Cancelable.nullCancelable);
		Assert.assertEquals(lengthBefore, file.length());
		Assert.assertEquals(modBefore, file.lastModified());
	}


	@Test
	public void testParseX() throws Exception {
		File file = TestFiles.docx.get();
		long lengthBefore = file.length();
		long modBefore = file.lastModified();
		ParseService.parse(new IndexingConfig(), file, file.getName(),
			new Path(file), IndexingReporter.nullReporter, Cancelable.nullCancelable);
		Assert.assertEquals(lengthBefore, file.length());
		Assert.assertEquals(modBefore, file.lastModified());
	}
	
	@Test
	public void testParseOld() throws Exception {
		File file = TestFiles.doc_old.get();
		long lengthBefore = file.length();
		long modBefore = file.lastModified();
		ParseService.parse(new IndexingConfig(), file, file.getName(),
			new Path(file), IndexingReporter.nullReporter, Cancelable.nullCancelable);
		Assert.assertEquals(lengthBefore, file.length());
		Assert.assertEquals(modBefore, file.lastModified());
	}
}
