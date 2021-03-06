package com.yida.design.abstractfactory.abs;

import com.yida.design.abstractfactory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:17:47
 ***********************
 */
public abstract class AbstractYellowHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("黄色人种的皮肤颜色是黄色的！");
	}

	@Override
	public void talk() {
		System.out.println("黄色人种会说话，一般说的都是双字节。");
	}

}
