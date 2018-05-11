package com.yida.design.Mediator.generator;

/**
 *********************
 * 抽象同事类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午5:39:52
 ***********************
 */
public abstract class Colleague {
	protected Mediator mediator;

	public Colleague(Mediator _mediator) {
		this.mediator = _mediator;
	}
}
