package com.yida.design.state.generator.impl;

import com.yida.design.state.generator.Context;
import com.yida.design.state.generator.State;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月9日 下午6:12:52
 ***********************
 */
public class ConcreteState1 extends State {

	@Override
	public void handle1() {
		// 本状态下必须处理的逻辑

	}

	@Override
	public void handle2() {
		// 设置当前状态为stat2
		super.context.setCurrentState(Context.STATE2);
		// 过渡到state2状态，由Context实现
		super.context.handle2();

	}

}
