package com.yida.design.factory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:02:43
 ***********************
 */
public interface Human {
	// 每个人种的皮肤都有相应的颜色
	public void getColor();

	// 人类会说话
	public void talk();
}
