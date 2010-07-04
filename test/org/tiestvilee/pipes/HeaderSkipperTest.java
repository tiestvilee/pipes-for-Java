package org.tiestvilee.pipes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.tiestvilee.pipes.adapters.ConsumingProcessorAdapter;
import org.tiestvilee.pipes.file.HeaderSkipper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HeaderSkipperTest {
	
	@Test
	public void shouldSkipLinesWhereFirstElementIsSameAsHeaderIdentifier() {
		HeaderSkipper skipper = new HeaderSkipper("identifier");
		final List<String[]> result = new ArrayList<String[]>();
		
		skipper.andFinally(new ConsumingProcessorAdapter<String[]>() {
			public void process(String[] line) {
				result.add(line);
			}
		});
		
		skipper.process(new String[] {"identifier"});
		skipper.process(new String[] {"not header", "identifier"});
		skipper.process(new String[] {"footer"});
		
		assertThat(result.size(), is(2));
		assertThat(result.get(0)[0], is("not header"));
		assertThat(result.get(1)[0], is("footer"));
	}
	
	@Test
	public void shouldCopeWithEmptyLines() {
		HeaderSkipper skipper = new HeaderSkipper("identifier");
		final List<String[]> result = new ArrayList<String[]>();
		
		skipper.andFinally(new ConsumingProcessorAdapter<String[]>() {
			public void process(String[] line) {
				result.add(line);
			}
		});
		
		skipper.process(new String[] {"identifier"});
		skipper.process(new String[] {});
		
		assertThat(result.size(), is(1));
		assertThat(result.get(0).length, is(0));
	}

}
