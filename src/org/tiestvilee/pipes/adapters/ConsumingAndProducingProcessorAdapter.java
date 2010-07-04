package org.tiestvilee.pipes.adapters;

import org.tiestvilee.pipes.ProducingProcessor;
import org.tiestvilee.pipes.ConsumingProcessor;
import org.tiestvilee.pipes.mixins.ProducingProcessorMixin;
import org.tiestvilee.pipes.mixins.ConsumingProcessorMixin;

public abstract class ConsumingAndProducingProcessorAdapter<T, U> implements ConsumingProcessor<T>, ProducingProcessor<U> {
	
	ProducingProcessorMixin<U> inputMixin = new ProducingProcessorMixin<U>(this);
	ConsumingProcessorMixin<T> outputMixin = new ConsumingProcessorMixin<T>();

	public ConsumingProcessor<U> andFinally(ConsumingProcessor<U> processor) {
		return inputMixin.andFinally(processor);
	}
	
	public <V> ProducingProcessor<V> andThen(ConsumingAndProducingProcessorAdapter<U, V> processor) {
		return inputMixin.andThen(processor);
	}
	
	public ConsumingProcessor<U> next() {
		return inputMixin.next();
	}

	public void afterLastInput() {
		outputMixin.afterLastInput();
	}

	public void setParent(ProducingProcessor<? extends Object> parent) {
		outputMixin.setParent(parent);
	}

	public void start(Object seed) {
		outputMixin.start(seed);
	}
	
}
