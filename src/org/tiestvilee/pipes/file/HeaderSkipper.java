package org.tiestvilee.pipes.file;

import org.tiestvilee.pipes.adapters.ConsumingAndProducingProcessorAdapter;

public class HeaderSkipper extends ConsumingAndProducingProcessorAdapter<String[], String[]> {
	
	private final String headerIdentifier;

	public HeaderSkipper(String headerIdentifier) {
		this.headerIdentifier = headerIdentifier;
	}

	public void process(String[] elements) {
		if(elements.length > 0 && headerIdentifier.equals(elements[0])) {
			// skip
		} else {
			next().process(elements);
		}
	}

}
