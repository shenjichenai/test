package com.yida.design.abstractfactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午3:27:44
 ***********************
 */
public interface HumanFactory {

	public Human createYellowHuman();

	public Human createWhiteHuman();

	public Human createBlackHuman();
}
