/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.model.impl;

import com.yida.design.model.HummerModel;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午5:37:02
 ***********************
 */
public class HummerH1Model extends HummerModel {

	@Override
	public void start() {
		System.out.println("悍马H1发动...");
	}

	@Override
	public void stop() {
		System.out.println("悍马H1停车...");
	}

	@Override
	public void alarm() {
		System.out.println("悍马H1鸣笛...");
	}

	@Override
	public void engineBoom() {
		System.out.println("悍马H1引擎声音是这样的...");
	}

}
