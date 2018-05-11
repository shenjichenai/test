package com.yida.design.Mediator.demo;

import com.yida.design.Mediator.demo.colleague.Purchase;
import com.yida.design.Mediator.demo.colleague.Sale;
import com.yida.design.Mediator.demo.colleague.Stock;
import com.yida.design.Mediator.demo.mediator.AbstractMediator;
import com.yida.design.Mediator.demo.mediator.Mediator;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午5:17:03
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		AbstractMediator mediator = new Mediator();
		System.out.println("------购买人员购买电脑------");
		Purchase purchase = new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		System.out.println("------销售人员销售电脑------");
		Sale sale = new Sale(mediator);
		sale.sellIBMComputer(1);
		System.out.println("------库房人员清库处理------");
		Stock stock = new Stock(mediator);
		stock.clearStock();
	}
}
