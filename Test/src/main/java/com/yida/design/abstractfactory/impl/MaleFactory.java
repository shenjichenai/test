package com.yida.design.abstractfactory.impl;

import com.yida.design.abstractfactory.Human;
import com.yida.design.abstractfactory.HumanFactory;
import com.yida.design.abstractfactory.abs.sex.MaleBlackHuman;
import com.yida.design.abstractfactory.abs.sex.MaleWhiteHuman;
import com.yida.design.abstractfactory.abs.sex.MaleYellowHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:32:23
 ***********************
 */
public class MaleFactory implements HumanFactory {

	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

	@Override
	public Human createWhiteHuman() {
		return new MaleWhiteHuman();
	}

	@Override
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}

}
