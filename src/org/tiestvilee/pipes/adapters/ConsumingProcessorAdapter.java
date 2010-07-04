package org.tiestvilee.pipes.adapters;

import org.tiestvilee.pipes.ProducingProcessor;
import org.tiestvilee.pipes.ConsumingProcessor;
import org.tiestvilee.pipes.mixins.ConsumingProcessorMixin;

public abstract class ConsumingProcessorAdapter<T> implements ConsumingProcessor<T> {

	private ConsumingProcessorMixin<T> outputMixin = new ConsumingProcessorMixin<T>();

	public void afterLastInput() {
		outputMixin.afterLastInput();
	}
	
	public void start(Object seed) {
		outputMixin.start(seed);
	}
	
	public void setParent(ProducingProcessor<? extends Object> parent) {
		outputMixin.setParent(parent);
	}


}
