package com.yida.cutimage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		int n = 10;
		CountDownLatch doneSignal = new CountDownLatch(n);

		for (int i = 0; i < n; ++i) { // create and start threads
			new Thread(new Worker(doneSignal)).start();
			doneSignal.countDown();
		}
		// // 等待所有的worker线程执行结束
		System.out.println("Finished.");

	}
}

class Worker implements Runnable {
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch doneSignal) {
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {
		try {
			List<String> urls = new ArrayList<>();
			urls.add("https://www.baidu.com/");
			List<String> paths = new ArrayList<>();
			paths.add("C:\\Users\\0\\Desktop\\temp\\images\\cut\\" + UUID.randomUUID() + ".JPG");
			EagleBrowser.main1(urls, paths);
			doneSignal.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
