/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.agency;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午3:21:49
 ***********************
 */
public interface IGamePlayer {
	// 登录游戏
	public void login(String user, String password);

	// 杀怪，网络游戏的主要特色
	public void killBoss();

	// 升级
	public void upgrade();
}
