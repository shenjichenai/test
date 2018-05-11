package com.yida.design.Mediator.demo.colleague;

import com.yida.design.Mediator.demo.mediator.AbstractMediator;

/**
 *********************
 * 采购管理
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午4:45:39
 ***********************
 */
public class Purchase extends AbstractColleague {
	public Purchase(AbstractMediator mediator) {
		super(mediator);
	}

	// 采购IBM电脑
	public void buyIBMcomputer(int number) {
		super.mediator.execute("purchase.buy", number);
	}

	// 不再采购IBM电脑
	public void refuseBuyIBM() {
		System.out.println("不再采购IBM电脑");
	}
}
