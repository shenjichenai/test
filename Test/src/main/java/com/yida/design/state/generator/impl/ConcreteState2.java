package com.yida.design.state.generator.impl;

import com.yida.design.state.generator.Context;
import com.yida.design.state.generator.State;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月9日 下午6:14:38
 ***********************
 */
public class ConcreteState2 extends State {

	@Override
	public void handle1() {
		// 设置当前状态为state1
		super.context.setCurrentState(Context.STATE1);
		// 过渡到state1状态，由Context实现
		super.context.handle1();

	}

	@Override
	public void handle2() {
		// 本状态下必须处理的逻辑
	}

}
