package com.yida.design.Mediator.generator;

/**
 *********************
 * 具体同事类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午5:40:35
 ***********************
 */
public class ConcreteColleague1 extends Colleague {

	public ConcreteColleague1(Mediator _mediator) {
		super(_mediator);
	}

	// 自有方法 self-method
	public void selfMethod1() {
		// 处理自己的业务逻辑
	}

	// 依赖方法 dep-method
	public void depMethod1() {
		// 处理自己的业务逻辑
		// 自己不能处理的业务逻辑，委托给中介者处理
		super.mediator.doSomething1();
	}
}
