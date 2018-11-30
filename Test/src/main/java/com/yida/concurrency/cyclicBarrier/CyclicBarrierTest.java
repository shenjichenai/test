package com.yida.concurrency.cyclicBarrier;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

import com.google.gson.Gson;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月4日 下午4:14:13
 ***********************
 */
public class CyclicBarrierTest {

	private final Map<String, Object> map = new ConcurrentHashMap<String, Object>();

	class Player implements Runnable {

		private CyclicBarrier cyclicBarrier;
		private int id;

		public Player(int id, CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				// Thread.sleep(200);
				map.put("玩家" + id, "正在玩第一关...");
				System.out.println("玩家" + id + "正在玩第一关...");
				cyclicBarrier.await();
				System.out.println("玩家" + id + "进入第二关...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

	public void main() {
		// CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println("所有玩家进入第二关！");
			}
		});

		for (int i = 0; i < 4; i++) {
			new Thread(this.new Player(i, cyclicBarrier)).start();
		}
		String json = new Gson().toJson(map);
		System.out.println(json);
	}

	public static void main(String[] args) {
		String a = "aa";
		"aa".equals(a);
	}
}
