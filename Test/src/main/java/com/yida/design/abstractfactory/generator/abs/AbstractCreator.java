/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.abstractfactory.generator.abs;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午4:22:34
 ***********************
 */
public abstract class AbstractCreator {
	// 创建A产品家族
	public abstract AbstractProductA createProductA();

	// 创建B产品家族
	public abstract AbstractProductB createProductB();
}
