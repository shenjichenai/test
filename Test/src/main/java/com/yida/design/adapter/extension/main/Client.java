package com.yida.design.adapter.extension.main;

import com.yida.design.adapter.demo.IUserInfo;
import com.yida.design.adapter.extension.IOuterUserBaseInfo;
import com.yida.design.adapter.extension.IOuterUserHomeInfo;
import com.yida.design.adapter.extension.IOuterUserOfficeInfo;
import com.yida.design.adapter.extension.adapter.OuterUserInfo;
import com.yida.design.adapter.extension.impl.OuterUserBaseInfo;
import com.yida.design.adapter.extension.impl.OuterUserHomeInfo;
import com.yida.design.adapter.extension.impl.OuterUserOfficeInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:42:32
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 外系统的人员信息
		IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
		IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
		IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
		// 传递三个对象
		IUserInfo youngGirl = new OuterUserInfo(baseInfo, homeInfo, officeInfo);
		// 从数据库中查到101个
		for (int i = 0; i < 101; i++) {
			youngGirl.getMobileNumber();
		}
	}
}
