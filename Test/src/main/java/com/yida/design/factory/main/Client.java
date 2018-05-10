package com.yida.design.factory.main;

import com.yida.design.factory.Creator;
import com.yida.design.factory.Product;
import com.yida.design.factory.extend.ConcreteCreator;
import com.yida.design.factory.extend.ConcreteProduct1;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午2:05:00
 ***********************
 */
public class Client {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Creator concator = new ConcreteCreator();
		Product product = concator.createProduct(ConcreteProduct1.class);
		/**
		 * 业务处理逻辑
		 */
	}
}
