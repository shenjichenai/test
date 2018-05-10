package com.yida.design.singleton;

/**
 *********************
 * 线程不安全
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 上午11:33:27
 ***********************
 */
public class UnsafetySingeton {
	private static UnsafetySingeton unsafetySingeton = null;

	// 限制产生多个对象
	private UnsafetySingeton() {
	}

	// 通过该方法获得实例对象
	public static UnsafetySingeton getSingleton() {
		if (unsafetySingeton == null) {
			unsafetySingeton = new UnsafetySingeton();
		}
		return unsafetySingeton;
	}
}
