/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.extend;

import com.yida.design.factory.Creator;
import com.yida.design.factory.Product;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:27:47
 ***********************
 */
public class ConcreteCreator extends Creator {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;

		try {
			product = (T) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) product;
	}

}
