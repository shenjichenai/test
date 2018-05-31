package com.yida.design.adapter.demo.main;

import com.yida.design.adapter.demo.IUserInfo;
import com.yida.design.adapter.demo.impl.OuterUserInfo;
import com.yida.design.adapter.demo.impl.UserInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午4:45:44
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		getOutCompanyUser();

	}

	private static void getOutCompanyUser() {
		// 老板一想不对呀，兔子不吃窝边草，还是找借用人员好点
		// 我们只修改了这句话
		IUserInfo youngGirl = new OuterUserInfo();
		// 从数据库中查到101个
		for (int i = 0; i < 101; i++) {
			youngGirl.getMobileNumber();
		}
	}

	public static void getSelfCompanyUser() {
		// 没有与外系统连接的时候，是这样写的
		IUserInfo youngGirl = new UserInfo();
		// 从数据库中查到101个
		for (int i = 0; i < 101; i++) {
			youngGirl.getMobileNumber();
		}

	}
}
