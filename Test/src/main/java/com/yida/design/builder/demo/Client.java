package com.yida.design.builder.demo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardPolicy());

		for (int i = 0; i < count; i++) {
			threadPoolExecutor.execute(new Worker(countDownLatch, director));
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

	@Override
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
