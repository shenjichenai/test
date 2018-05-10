package com.yida.design.builder.demo;

import com.yida.design.builder.demo.car.BMWModel;
import com.yida.design.builder.demo.car.BenzModel;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:59:27
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		for (int i = 0; i < 1000; i++) {
			BenzModel benzModel = director.getABenzModel();
			benzModel.run();
		}
		for (int i = 0; i < 10000; i++) {
			BMWModel bbmwModel = director.getBBMWModel();
			bbmwModel.run();
		}
	}
}
