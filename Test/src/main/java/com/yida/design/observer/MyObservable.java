/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.observer;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月16日 下午2:28:45
 ***********************
 */
public class MyObservable extends IHanFeiZi {

	@Override
	public void hanFeiZiDoSomething() {
		System.err.println("吃饭了");
		this.setChanged();
		this.notifyObservers("恶汉变饱汗");
	}

}
