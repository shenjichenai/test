package com.yida.design.decorator.abs;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月31日 下午2:34:56
 ***********************
 */
public abstract class AbstractDecorator extends AbstractSchoolReport {
	// 首先我要知道是哪个成绩单
	private AbstractSchoolReport sr;

	// 构造函数，传递成绩单过来
	public AbstractDecorator(AbstractSchoolReport sr) {
		this.sr = sr;
	}

	// 成绩单还是要被看到的
	@Override
	public void report() {
		this.sr.report();
	}

	// 看完还是要签名的
	@Override
	public void sign(String name) {
		this.sr.sign(name);
	}

}
