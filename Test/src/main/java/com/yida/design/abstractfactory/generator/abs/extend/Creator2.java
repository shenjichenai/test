package com.yida.design.abstractfactory.generator.abs.extend;

import com.yida.design.abstractfactory.generator.abs.AbstractCreator;
import com.yida.design.abstractfactory.generator.abs.AbstractProductA;
import com.yida.design.abstractfactory.generator.abs.AbstractProductB;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午4:28:14
 ***********************
 */
public class Creator2 extends AbstractCreator {

	@Override
	public AbstractProductA createProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ProductB2();
	}

}
