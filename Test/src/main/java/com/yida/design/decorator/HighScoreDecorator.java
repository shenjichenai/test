/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.decorator;

import com.yida.design.decorator.abs.Decorator;
import com.yida.design.decorator.abs.SchoolReport;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午2:37:39
 ***********************
 */
public class HighScoreDecorator extends Decorator {

	public HighScoreDecorator(SchoolReport sr) {
		super(sr);
	}

	// 我要汇报最高成绩
	private void reportHighScore() {
		System.out.println("这次考试语文最高是75，数学是78，自然是80");
	}

	// 我要在老爸看成绩单前告诉他最高成绩，否则等他一看，就抡起扫帚揍我，我哪里还有机会说啊
	@Override
	public void report() {
		this.reportHighScore();
		super.report();
	}
}
