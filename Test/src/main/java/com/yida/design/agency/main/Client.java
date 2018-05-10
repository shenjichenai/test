/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.agency.main;

import com.yida.design.agency.IGamePlayer;
import com.yida.design.agency.impl.GamePlayer;
import com.yida.design.agency.impl.GamePlayerProxy;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午3:24:40
 ***********************
 */
public class Client {

	public static void main(String[] args) {
		// 定义一个痴迷的玩家
		IGamePlayer player = new GamePlayer("张三");

		GamePlayerProxy proxy = new GamePlayerProxy(player);
		// 开始打游戏，记下时间戳
		System.out.println("开始时间是：2009-8-25 10:45");
		proxy.login("zhangSan", "password");
		// 开始杀怪
		proxy.killBoss();
		// 升级
		proxy.upgrade();
		// 记录结束游戏时间
		System.out.println("结束时间是：2009-8-26 03:40");
	}

}
