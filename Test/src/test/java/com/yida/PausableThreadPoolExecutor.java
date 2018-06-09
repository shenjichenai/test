package com.yida;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月8日 上午10:54:25
 ***********************
 */
public class PausableThreadPoolExecutor extends ThreadPoolExecutor {

	public PausableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	static class CustomTask<V> implements RunnableFuture<V> {

		public CustomTask(Callable<V> c) {
			// TODO Auto-generated constructor stub
		}

		public CustomTask(Runnable r, V v) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCancelled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public V get() throws InterruptedException, ExecutionException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}
	}

	@Override
	protected <V> RunnableFuture<V> newTaskFor(Callable<V> c) {
		return new CustomTask<V>(c);
	}

	@Override
	protected <V> RunnableFuture<V> newTaskFor(Runnable r, V v) {
		return new CustomTask<V>(r, v);
	} // ... add constructors, etc.

}
