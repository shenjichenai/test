package com.yida.design.decorator;

import com.yida.design.decorator.abs.AbstractSchoolReport;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月30日 下午5:50:19
 ***********************
 */
public class FouthGradeSchoolReport extends AbstractSchoolReport {

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
