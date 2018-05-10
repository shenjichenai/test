/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.model.generator;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午5:51:24
 ***********************
 */
public abstract class AbstractClass {
	// 基本方法
	protected abstract void doSomething();

	// 基本方法
	protected abstract void doAnything();

	// 模板方法
	public void templateMethod() {
		/*
		 * 调用基本方法，完成相关的逻辑
		 */
		this.doAnything();
		this.doSomething();
	}
}
