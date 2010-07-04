package org.tiestvilee.pipes.mixins;

import org.tiestvilee.pipes.ProducingProcessor;

public class ConsumingProcessorMixin<T> {

	private ProducingProcessor<? extends Object> parent;

	public void afterLastInput() {
		// do nothing by default
	}
	
	public void start(Object seed) {
		parent.start(seed);
	}
	
	public void setParent(ProducingProcessor<? extends Object> parent) {
		this.parent = parent;
	}


}
