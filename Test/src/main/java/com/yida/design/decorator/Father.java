package com.yida.design.decorator;

import com.yida.design.decorator.abs.AbstractSchoolReport;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月30日 下午5:53:14
 ***********************
 */
public class Father {
	public static void main(String[] args) {
		// 把成绩单拿过来
		AbstractSchoolReport sr;
		// 原装的成绩单
		sr = new FouthGradeSchoolReport();
		// 加了最高分说明的成绩单
		sr = new HighScoreDecorator(sr);
		// 又加了成绩排名的说明
		sr = new SortDecorator(sr);
		// 看成绩单
		sr.report();
		// 然后老爸一看，很开心，就签名了
		sr.sign("老三"); // 我叫小三，老爸当然叫老三
	}
}
