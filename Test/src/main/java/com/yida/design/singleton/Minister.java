/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.singleton;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 上午10:25:47
 ***********************
 */
public class Minister {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// 定义5个大臣
		int ministerNum = 5;
		for (int i = 0; i < ministerNum; i++) {
			Emperor emperor = Emperor.getInstance();
			System.out.print("第" + (i + 1) + "个大臣参拜的是：");
			emperor.say();
		}
	}
}
