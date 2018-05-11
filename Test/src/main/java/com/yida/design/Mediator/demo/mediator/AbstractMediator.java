package com.yida.design.Mediator.demo.mediator;

import com.yida.design.Mediator.demo.colleague.Purchase;
import com.yida.design.Mediator.demo.colleague.Sale;
import com.yida.design.Mediator.demo.colleague.Stock;

/**
 *********************
 * 抽象中介者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午4:42:55
 ***********************
 */
public abstract class AbstractMediator {
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;

	// 构造函数
	public AbstractMediator() {
		purchase = new Purchase(this);
		sale = new Sale(this);
		stock = new Stock(this);
	}

	// 中介者最重要的方法叫做事件方法，处理多个对象之间的关系
	public abstract void execute(String str, Object... objects);
}
