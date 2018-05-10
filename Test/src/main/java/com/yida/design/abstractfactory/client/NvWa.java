package com.yida.design.abstractfactory.client;

import com.yida.design.abstractfactory.Human;
import com.yida.design.abstractfactory.HumanFactory;
import com.yida.design.abstractfactory.impl.FemaleFactory;
import com.yida.design.abstractfactory.impl.MaleFactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:33:43
 ***********************
 */
public class NvWa {
	public static void main(String[] args) {
		HumanFactory femaleFactory = new FemaleFactory();
		HumanFactory maleFactory = new MaleFactory();

		Human femaleBlackHuman = femaleFactory.createBlackHuman();
		femaleBlackHuman.getColor();
		femaleBlackHuman.getSex();
		femaleBlackHuman.talk();

		Human maleYellowHuman = maleFactory.createYellowHuman();
		maleYellowHuman.getColor();
		maleYellowHuman.getSex();
		maleYellowHuman.talk();
	}
}
