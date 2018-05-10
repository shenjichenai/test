package com.yida.design.abstractfactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:14:32
 ***********************
 */
public interface Human {
	// 每个人种都有相应的颜色
	public void getColor();

	// 人类会说话
	public void talk();

	// 每个人都有性别
	public void getSex();
}
