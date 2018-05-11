package com.yida.design.builder.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.yida.design.builder.demo.car.BMWModel;
import com.yida.design.builder.demo.car.BenzModel;

/**
 *********************
 * 可能会报错，因为Director类全局变量sequence并非线程安全
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:59:27
 ***********************
 */
public class Client {

	public static void main(String[] args) {
		int count = 100;
		CountDownLatch countDownLatch = new CountDownLatch(count);
		Director director = new Director();

		for (int i = 0; i < count; i++) {
			new Thread(new Worker(countDownLatch, director)).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Worker implements Runnable {

	private final CountDownLatch countDownLatch;
	private final Director director;

	public Worker(CountDownLatch countDownLatch, Director director) {
		this.countDownLatch = countDownLatch;
		this.director = director;
	}

	public void run() {
		Random random = new Random();
		int nextInt = random.nextInt(2);
		if (nextInt == 0) {
			BenzModel benzModel = director.getABenzModel();
			benzModel.run();
		} else {
			BMWModel bbmwModel = director.getBBMWModel();
			bbmwModel.run();
		}
		countDownLatch.countDown();
	}

}
