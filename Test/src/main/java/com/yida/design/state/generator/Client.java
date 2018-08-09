package com.yida.design.state.generator;

import com.yida.design.state.generator.impl.ConcreteState1;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月9日 下午6:16:15
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 定义环境角色
		Context context = new Context();
		// 初始化状态
		context.setCurrentState(new ConcreteState1());
		// 行为执行
		context.handle1();
		context.handle2();
	}
}
