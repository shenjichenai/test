/**
 */
package com.yida.design.abstractfactory.abs;

import com.yida.design.abstractfactory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:16:57
 ***********************
 */
public abstract class AbstractBlackHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("黑色人种的皮肤颜色是黑色的！");
	}

	@Override
	public void talk() {
		System.out.println("黑人会说话，一般人听不懂。");
	}

}
