package com.yida.design.strategy.demo.strategy;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:14:49
 ***********************
 */
public class BackDoor implements IStrategy {

	@Override
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
	}

}
