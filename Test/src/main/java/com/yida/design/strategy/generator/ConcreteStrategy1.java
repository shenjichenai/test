package com.yida.design.strategy.generator;

/**
 *********************
 * 具体策略角色
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:32:06
 ***********************
 */
public class ConcreteStrategy1 implements Strategy {

	public void doSomething() {
		System.out.println("具体策略1的运算法则");
	}

}
