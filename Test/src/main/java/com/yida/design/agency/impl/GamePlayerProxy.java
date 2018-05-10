package com.yida.design.agency.impl;

import com.yida.design.agency.IGamePlayer;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午3:28:37
 ***********************
 */
public class GamePlayerProxy implements IGamePlayer {

	private IGamePlayer gamePlayer = null;

	// 通过构造函数传递要对谁进行代练
	public GamePlayerProxy(IGamePlayer _gamePlayer) {
		this.gamePlayer = _gamePlayer;
	}

	// 代练杀怪
	public void killBoss() {
		this.gamePlayer.killBoss();
	}

	// 代练登录
	public void login(String user, String password) {
		this.gamePlayer.login(user, password);
	}

	// 代练升级
	public void upgrade() {
		this.gamePlayer.upgrade();
	}

	public IGamePlayer getProxy() {
		return null;
	}

}
