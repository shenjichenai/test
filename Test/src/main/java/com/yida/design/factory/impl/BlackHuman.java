/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.impl;

import com.yida.design.factory.Human;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:03:41
 ***********************
 */
public class BlackHuman implements Human {

	public void getColor() {
		System.out.println("黑色人种的皮肤颜色是黑色的！");
	}

	public void talk() {
		System.out.println("黑人会说话，一般人听不懂。");
	}

}
