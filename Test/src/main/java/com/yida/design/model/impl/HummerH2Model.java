package com.yida.design.model.impl;

import com.yida.design.model.HummerModel;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午5:39:45
 ***********************
 */
public class HummerH2Model extends HummerModel {

	@Override
	public void start() {
		System.out.println("悍马H2发动...");
	}

	@Override
	public void stop() {
		System.out.println("悍马H2停车...");
	}

	@Override
	public void alarm() {
		System.out.println("悍马H2鸣笛...");
	}

	@Override
	public void engineBoom() {
		System.out.println("悍马H2引擎声音是这样在...");
	}

}
