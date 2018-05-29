package com.yida.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 *********************
 * 测试类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月25日 上午10:16:33
 ***********************
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		List<String> urls = new ArrayList<>();
		urls.add("http://localhost:8080/tancms-server/jsp/login.jsp");
		urls.add("http://localhost:8080/tancms-server/jsp/regist.jsp");
		List<String> paths = new ArrayList<>();
		paths.add("C:\\Users\\0\\Desktop\\temp\\images\\cut\\" + UUID.randomUUID() + ".JPG");
		paths.add("C:\\Users\\0\\Desktop\\temp\\images\\cut\\" + UUID.randomUUID() + ".JPG");
		CutPictureUtils.cutPicture(urls, paths);
	}

	/**
	 * countDownLatch测试用例
	 */
	public void countDownLatchTest() {
		int N = 10;
		CountDownLatch doneSignal = new CountDownLatch(N);

		for (int i = 0; i < N; ++i) { // create and start threads
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

	public void run() {
		try {
			List<String> urls = new ArrayList<>();
			urls.add("https://www.baidu.com/");
			List<String> paths = new ArrayList<>();
			paths.add("C:\\Users\\0\\Desktop\\temp\\images\\cut\\" + UUID.randomUUID() + ".JPG");
			CutPictureUtils.cutPicture(urls, paths);
			doneSignal.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
