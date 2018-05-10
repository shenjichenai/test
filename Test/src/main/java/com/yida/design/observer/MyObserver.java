/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月16日 下午2:25:06
 ***********************
 */
public class MyObserver implements Observer {

	public void update(Observable o, Object arg) {
		System.err.println("观察到了：" + arg);
	}

}
