package com.yida.design.abstractfactory.generator.abs;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午4:17:55
 ***********************
 */
public abstract class AbstractProductB {
	// 每个产品共有的方法
	public void shareMethod() {
	}

	// 每个产品相同方法，不同实现
	public abstract void doSomething();
}
