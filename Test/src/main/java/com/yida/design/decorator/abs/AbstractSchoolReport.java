package com.yida.design.decorator.abs;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月19日 下午5:39:55
 ***********************
 */
public abstract class AbstractSchoolReport {
	// 成绩单主要展示的就是你的成绩情况
	public abstract void report();

	// 成绩单要家长签字，这个是最要命的
	public abstract void sign(String name);
}
