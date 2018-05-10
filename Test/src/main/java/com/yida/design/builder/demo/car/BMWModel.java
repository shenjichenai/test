package com.yida.design.builder.demo.car;

/**
 *********************
 * 宝马模型
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:41:55
 ***********************
 */
public class BMWModel extends CarModel {

	@Override
	protected void start() {
		System.out.println("宝马车跑起来是这个样子的...");
	}

	@Override
	protected void stop() {
		System.out.println("宝马车应该这样停车...");
	}

	@Override
	protected void alarm() {
		System.out.println("宝马车的喇叭声音是这个样子的...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("宝马车的引擎是这个声音的...");
	}

}
