package org.tiestvilee.pipes;

import org.junit.Test;
import org.tiestvilee.pipes.file.FileLineProcessor;
import org.tiestvilee.pipes.file.HeaderSkipper;
import org.tiestvilee.pipes.file.PrintElements;
import org.tiestvilee.pipes.file.SplitLineProcessor;


public class FileLineProcessorTest {

	@Test
	public void shouldReadSomeLines() throws Exception {
		FileLineProcessor readFile = new FileLineProcessor();
		
		readFile
		    .andThen(new SplitLineProcessor("\\|"))
		    .andThen(new HeaderSkipper("header"))
		    .andFinally(new PrintElements())
		    .start("test/org/tiestvilee/pipes/testfile1");
	}
}
