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
