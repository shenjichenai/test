package com.yida.design.factory.impl;

import com.yida.design.factory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:04:29
 ***********************
 */
public class YellowHuman implements Human {

	public void getColor() {
		System.out.println("黄色人种的皮肤颜色是黄色的！");
	}

	public void talk() {
		System.out.println("黄色人种会说话，一般说的都是双字节。");
	}

}
