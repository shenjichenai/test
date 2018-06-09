/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.abstractfactory.abs.sex;

import com.yida.design.abstractfactory.abs.AbstractWhiteHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:26:09
 ***********************
 */
public class FemaleWhiteHuman extends AbstractWhiteHuman {

	@Override
	public void getSex() {
		System.out.println("白人女性");
	}

}
