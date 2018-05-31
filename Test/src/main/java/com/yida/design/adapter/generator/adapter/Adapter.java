/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.adapter.generator.adapter;

import com.yida.design.adapter.generator.Adaptee;
import com.yida.design.adapter.generator.Target;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:08:48
 ***********************
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void request() {
		super.doSomething();
	}

}
