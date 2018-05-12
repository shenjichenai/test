package com.yida.design.strategy.demo.strategy;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:15:30
 ***********************
 */
public class GivenGreenLight implements IStrategy {

	public void operate() {
		System.out.println("求吴国太开绿灯,放行！");
	}

}
