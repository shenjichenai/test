/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:26:24
 ***********************
 */
public abstract class Creator {
	public abstract <T extends Product> T createProduct(Class<T> c);
}
