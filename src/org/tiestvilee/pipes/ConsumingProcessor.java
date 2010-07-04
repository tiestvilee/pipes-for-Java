package org.tiestvilee.pipes;

public interface ConsumingProcessor<T> extends Processor {

	public void process(T line);

	public void afterLastInput();

	public void setParent(ProducingProcessor<? extends Object> parent);

}