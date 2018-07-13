package com.yida.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
		testQuick();// 快速排序
		testShell();// 希尔排序
		testHeap();// 堆排序
		testMerge();// 归并排序
		testSelection();// 直接排序
		testInsert();// 直接插入排序
		testSort();// 基数排序
		testBubble();// 冒泡排序
	}

	private static void testQuick() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}

		// 快速排序
		long start = System.currentTimeMillis();
		SortUtils.quickSort(list, 0, list.length - 1);
		long end = System.currentTimeMillis();
		System.out.println("快速排序耗费的时间：" + (end - start));
		display(list);
	}

	private static void testShell() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}

		// 希尔排序
		long start = System.currentTimeMillis();
		SortUtils.shellSort(list);
		long end = System.currentTimeMillis();
		System.out.println("希尔排序耗费的时间：" + (end - start));
		display(list);
	}

	private static void testHeap() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}
		long start = System.currentTimeMillis();
		SortUtils.heapSort(list);
		long end = System.currentTimeMillis();
		System.out.println("堆排序排序耗费的时间：" + (end - start));
		display(list);

	}

	private static void testMerge() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}
		long start = System.currentTimeMillis();
		SortUtils.mergeSort(list, new int[list.length], 0, list.length - 1);
		long end = System.currentTimeMillis();
		System.out.println("归并排序排序耗费的时间：" + (end - start));
		display(list);

	}

	private static void testSelection() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}
		long start = System.currentTimeMillis();
		SortUtils.selectSort(list);
		long end = System.currentTimeMillis();
		System.out.println("简单选择排序耗费的时间：" + (end - start));
		display(list);

	}

	private static void testInsert() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}

		// 直接插入排序
		long start = System.currentTimeMillis();
		SortUtils.insertSort(list);
		long end = System.currentTimeMillis();
		System.out.println("直接插入排序耗费的时间：" + (end - start));
		display(list);

	}

	private static void testSort() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}

		// 基数排序
		long start = System.currentTimeMillis();
		SortUtils.sort(list);
		long end = System.currentTimeMillis();
		System.out.println("基数排序耗费的时间：" + (end - start));
		display(list);

	}

	private static void testBubble() {
		int[] list = new int[10000];
		for (int i = 0; i < 10000; i++) {
			list[i] = (int) (Math.random() * 100000);
		}

		// 冒泡排序
		long start = System.currentTimeMillis();
		SortUtils.bubbleSort(list);
		long end = System.currentTimeMillis();
		System.out.println("冒泡排序耗费的时间：" + (end - start));
		display(list);
	}

	/**
	 * 打印变量前十个
	 * 
	 * @param list
	 */
	private static void display(int[] list) {
		System.out.println("********排序之后的前10个数start********");
		if (list != null && list.length > 0) {
			for (int i = 0; i < 10; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println("");
		}
		System.out.println("********排序之后的前10个数end**********");
		System.out.println("");
	}

	/**
	 * countDownLatch测试用例
	 */
	public void countDownLatchTest() {
		int n = 10;
		CountDownLatch doneSignal = new CountDownLatch(n);

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 3, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

		for (int i = 0; i < n; ++i) { // create and start threads
			threadPool.execute(new Worker(doneSignal));
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
			CutPictureUtils.cutPicture(urls, paths);
			doneSignal.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
