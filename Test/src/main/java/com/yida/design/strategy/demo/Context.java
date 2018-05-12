package com.yida.design.strategy.demo;

import com.yida.design.strategy.demo.strategy.IStrategy;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:17:31
 ***********************
 */
public class Context {
	private IStrategy strategy;

	// 用什么策略初始化
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	// 执行策略
	public void operate() {
		this.strategy.operate();
	}
}
