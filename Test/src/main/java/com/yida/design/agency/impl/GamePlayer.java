package com.yida.design.agency.impl;

import com.yida.design.agency.IGamePlayer;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午3:22:42
 ***********************
 */
public class GamePlayer implements IGamePlayer {

	private String name = "";

	public GamePlayer(String name) {
		this.name = name;
	}

	public void login(String user, String password) {
		System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
	}

	public void killBoss() {
		System.out.println(this.name + "在打怪！");
	}

	public void upgrade() {
		System.out.println(this.name + " 又升了一级！");
	}

}
