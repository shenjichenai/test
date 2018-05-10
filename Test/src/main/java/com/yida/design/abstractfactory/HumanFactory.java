/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
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
