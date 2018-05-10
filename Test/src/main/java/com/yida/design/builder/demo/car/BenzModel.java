package com.yida.design.builder.demo.car;

/**
 *********************
 * 奔驰模型
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:40:37
 ***********************
 */
public class BenzModel extends CarModel {

	@Override
	protected void start() {
		System.out.println("奔驰车跑起来是这个样子的...");
	}

	@Override
	protected void stop() {
		System.out.println("奔驰车应该这样停车...");
	}

	@Override
	protected void alarm() {
		System.out.println("奔驰车的喇叭声音是这个样子的...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("奔驰车的引擎是这个声音的...");
	}

}
