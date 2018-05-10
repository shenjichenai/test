/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.factory.singleton;

import java.lang.reflect.Constructor;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午2:42:56
 ***********************
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SingletonFactory {
	@SuppressWarnings("unused")
	private static Singleton singleton;

	static {
		try {
			Class clazz = Class.forName(Singleton.class.getName());
			// 获得无参构造
			Constructor constructor = clazz.getDeclaredConstructor();
			// 设置无参构造是可访问的
			constructor.setAccessible(true);
			// 产生一个实例对象
			singleton = (Singleton) constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
