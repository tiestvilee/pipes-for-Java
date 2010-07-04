package org.tiestvilee.pipes.file;

import org.tiestvilee.pipes.adapters.ConsumingAndProducingProcessorAdapter;

public class SplitLineProcessor extends ConsumingAndProducingProcessorAdapter<String, String[]> {

	private String delimiter;
	
	public SplitLineProcessor(String delimiter) {
		this.delimiter = delimiter;
	}

	public void process(String line) {
		next().process(line.split(delimiter));
	}

}
