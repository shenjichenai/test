/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.singleton;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 上午10:29:21
 ***********************
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();

	public Singleton() {
	}

	public static Singleton getSingleton() {
		return singleton;
	}

	// 类中其他方法，尽量是static
	public static void doSomething() {
	}

}
