/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.impl;

import com.yida.design.factory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:05:15
 ***********************
 */
public class WhiteHuman implements Human {

	public void getColor() {
		System.out.println("白色人种的皮肤颜色是白色的！");
	}

	public void talk() {
		System.out.println("白色人种会说话，一般都是但是单字节。");
	}

}
