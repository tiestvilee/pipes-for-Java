package org.tiestvilee.pipes.mixins;

import org.tiestvilee.pipes.ProducingProcessor;
import org.tiestvilee.pipes.ConsumingProcessor;
import org.tiestvilee.pipes.adapters.ConsumingAndProducingProcessorAdapter;

public class ProducingProcessorMixin<U> {
	private ConsumingProcessor<U> next;
	private final ProducingProcessor<U> actual;
	
	public ProducingProcessorMixin(ProducingProcessor<U> actual) {
		this.actual = actual;
	}
	
	public ConsumingProcessor<U> andFinally(ConsumingProcessor<U> processor) {
		processor.setParent(actual);
		next = processor;
		return processor;
	}

	public <V> ProducingProcessor<V> andThen(ConsumingAndProducingProcessorAdapter<U, V> processor) {
		processor.setParent(actual);
		next = processor;
		return processor;
	}
	
	public ConsumingProcessor<U> next() {
		return next;
	}

}
