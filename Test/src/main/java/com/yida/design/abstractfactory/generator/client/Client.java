package com.yida.design.abstractfactory.generator.client;

import com.yida.design.abstractfactory.generator.abs.AbstractCreator;
import com.yida.design.abstractfactory.generator.abs.AbstractProductA;
import com.yida.design.abstractfactory.generator.abs.AbstractProductB;
import com.yida.design.abstractfactory.generator.abs.extend.Creator1;
import com.yida.design.abstractfactory.generator.abs.extend.Creator2;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午4:29:16
 ***********************
 */
public class Client {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractCreator creator1 = new Creator1();
		AbstractCreator creator2 = new Creator2();

		AbstractProductA createProductA = creator1.createProductA();
		AbstractProductB createProductB = creator1.createProductB();

		AbstractProductA createProductA2 = creator2.createProductA();
		AbstractProductB createProductB2 = creator2.createProductB();

		/*
		 * 然后在这里就可以为所欲为了...
		 */
	}
}
