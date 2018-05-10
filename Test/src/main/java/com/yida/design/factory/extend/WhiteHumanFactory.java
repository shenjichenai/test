package com.yida.design.factory.extend;

import com.yida.design.factory.AbstractHumanFactory2;
import com.yida.design.factory.Human;
import com.yida.design.factory.impl.WhiteHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午2:35:27
 ***********************
 */
public class WhiteHumanFactory extends AbstractHumanFactory2 {

	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}

}
