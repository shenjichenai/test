/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.model.generator;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午5:53:25
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		AbstractClass concrete1 = new ConcreteClass1();
		AbstractClass concrete2 = new ConcreteClass2();

		concrete1.templateMethod();
		concrete2.templateMethod();
	}
}
