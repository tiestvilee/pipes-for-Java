package org.tiestvilee.pipes;

import org.tiestvilee.pipes.adapters.ConsumingAndProducingProcessorAdapter;

public interface ProducingProcessor<T> extends Processor {

	public ConsumingProcessor<T> andFinally(ConsumingProcessor<T> processor);

	public <V> ProducingProcessor<V> andThen(ConsumingAndProducingProcessorAdapter<T, V> processor);
	
	public ConsumingProcessor<T> next();

}
