package com.yida.design.abstractfactory.abs;

import com.yida.design.abstractfactory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:15:44
 ***********************
 */
public abstract class AbstractWhiteHuman implements Human {

	public void getColor() {
		System.out.println("白色人种的皮肤颜色是白色的！");
	}

	public void talk() {
		System.out.println("白色人种会说话，一般说的都是单字节。");
	}

}
