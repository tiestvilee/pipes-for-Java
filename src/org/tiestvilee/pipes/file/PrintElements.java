package org.tiestvilee.pipes.file;

import org.tiestvilee.pipes.adapters.ConsumingProcessorAdapter;

public class PrintElements extends ConsumingProcessorAdapter<String[]> {

	public void process(String[] elements) {
		System.out.print("\nanother line!");
		for(String element : elements) {
			System.out.print( "..." + element);
		}
	}

}
