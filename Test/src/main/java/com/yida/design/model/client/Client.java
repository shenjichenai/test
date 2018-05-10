/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.model.client;

import com.yida.design.model.HummerModel;
import com.yida.design.model.impl.HummerH1Model;
import com.yida.design.model.impl.HummerH2Model;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午5:42:39
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		HummerModel hummerH1Model = new HummerH1Model();
		HummerModel hummerH2Model = new HummerH2Model();

		hummerH1Model.run();
		hummerH2Model.run();
	}
}
