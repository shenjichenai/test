package com.yida.design.decorator;

import com.yida.design.decorator.abs.Decorator;
import com.yida.design.decorator.abs.SchoolReport;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午2:43:49
 ***********************
 */
public class SortDecorator extends Decorator {

	public SortDecorator(SchoolReport sr) {
		super(sr);
	}

	// 告诉老爸学校的排名情况
	private void reportSort() {
		System.out.println("我是排名第38名...");
	}

	// 老爸看完成绩单后再告诉他，加强作用
	@Override
	public void report() {
		super.report();
		this.reportSort();
	}
}
