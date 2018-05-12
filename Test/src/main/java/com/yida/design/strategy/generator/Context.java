package com.yida.design.strategy.generator;

/**
 *********************
 * 封装角色
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:40:58
 ***********************
 */
public class Context {
	// 抽象策略
	private Strategy strategy = null;

	// 构造函数设置具体策略
	public Context(Strategy _strategy) {
		this.strategy = _strategy;
	}

	// 封装后的策略方法
	public void doAnythinig() {
		this.strategy.doSomething();
	}
}
