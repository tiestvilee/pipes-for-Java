package org.tiestvilee.pipes.adapters;

import org.tiestvilee.pipes.ProducingProcessor;
import org.tiestvilee.pipes.ConsumingProcessor;
import org.tiestvilee.pipes.mixins.ProducingProcessorMixin;

public abstract class ProducingProcessorAdapter<T> implements ProducingProcessor<T> {

	private ProducingProcessorMixin<T> inputMixin = new ProducingProcessorMixin<T>(this);
	
	public ConsumingProcessor<T> andFinally(ConsumingProcessor<T> processor) {
		return inputMixin.andFinally(processor);
	}

	public <V> ProducingProcessor<V> andThen(ConsumingAndProducingProcessorAdapter<T, V> processor) {
		return inputMixin.andThen(processor);
	}

	public ConsumingProcessor<T> next() {
		return inputMixin.next();
	}
}
