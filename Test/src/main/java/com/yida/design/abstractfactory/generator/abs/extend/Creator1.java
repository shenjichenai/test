/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.abstractfactory.generator.abs.extend;

import com.yida.design.abstractfactory.generator.abs.AbstractCreator;
import com.yida.design.abstractfactory.generator.abs.AbstractProductA;
import com.yida.design.abstractfactory.generator.abs.AbstractProductB;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午4:27:28
 ***********************
 */
public class Creator1 extends AbstractCreator {

	@Override
	public AbstractProductA createProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ProductB1();
	}

}
