package com.yida.design.abstractfactory.impl;

import com.yida.design.abstractfactory.Human;
import com.yida.design.abstractfactory.HumanFactory;
import com.yida.design.abstractfactory.abs.sex.FemaleBlackHuman;
import com.yida.design.abstractfactory.abs.sex.FemaleWhiteHuman;
import com.yida.design.abstractfactory.abs.sex.FemaleYellowHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:30:39
 ***********************
 */
public class FemaleFactory implements HumanFactory {

	public Human createYellowHuman() {
		return new FemaleYellowHuman();
	}

	public Human createWhiteHuman() {
		return new FemaleWhiteHuman();
	}

	public Human createBlackHuman() {
		return new FemaleBlackHuman();
	}

}
