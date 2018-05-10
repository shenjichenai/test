/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.decorator;

import com.yida.design.decorator.abs.SchoolReport;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月30日 下午5:50:19
 ***********************
 */
public class FouthGradeSchoolReport extends SchoolReport {

	@Override
	public void report() {
		// 成绩单的格式是这个样子的
		System.out.println("尊敬的XXX家长:");
		System.out.println(" ......");
		System.out.println(" 语文 62 数学65 体育 98 自然 63");
		System.out.println(" .......");
		System.out.println(" 家长签名： ");

	}

	@Override
	public void sign(String name) {
		System.out.println("家长签名为：" + name);
	}

}
