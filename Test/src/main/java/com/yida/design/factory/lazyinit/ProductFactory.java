/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.lazyinit;

import java.util.HashMap;
import java.util.Map;

import com.yida.design.factory.Product;
import com.yida.design.factory.extend.ConcreteProduct1;
import com.yida.design.factory.extend.ConcreteProduct2;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午2:56:55
 ***********************
 */
public class ProductFactory {

	private static final Map<String, Product> prMap = new HashMap<String, Product>();

	public static synchronized Product createPruduct(String type) {
		Product product = null;
		if (prMap.containsKey(type)) {
			return prMap.get(type);
		} else {
			if ("Product1".equals(type)) {
				product = new ConcreteProduct1();
			} else {
				product = new ConcreteProduct2();
			}
			prMap.put(type, product);
		}

		return product;
	}
}
