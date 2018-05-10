/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.extend;

import com.yida.design.factory.AbstractHumanFactory2;
import com.yida.design.factory.Human;
import com.yida.design.factory.impl.BlackHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午2:33:57
 ***********************
 */
public class BlackHumanFactory extends AbstractHumanFactory2 {

	@Override
	public Human createHuman() {
		return new BlackHuman();
	}

}
