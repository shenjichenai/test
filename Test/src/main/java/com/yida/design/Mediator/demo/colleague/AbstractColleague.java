package com.yida.design.Mediator.demo.colleague;

import com.yida.design.Mediator.demo.mediator.AbstractMediator;

/**
 *********************
 * 抽象同事类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午4:57:55
 ***********************
 */
public abstract class AbstractColleague {
	protected AbstractMediator mediator;

	public AbstractColleague(AbstractMediator mediator) {
		super();
		this.mediator = mediator;
	}
}
