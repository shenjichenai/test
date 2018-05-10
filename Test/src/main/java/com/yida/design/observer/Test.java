package com.yida.design.observer;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年3月16日 下午2:36:16
 ***********************
 */
public class Test {
	public static void main(String[] args) {
		MyObserver myObserver = new MyObserver();
		MyObservable myObservable = new MyObservable();
		myObservable.addObserver(myObserver);
		myObservable.hanFeiZiDoSomething();
	}

	@org.junit.Test
	public void test() {
		String a = "asssdfd";
		String[] split = a.split(" ");
		for (String string : split) {
			System.err.println("s=" + string);
		}
	}
}
