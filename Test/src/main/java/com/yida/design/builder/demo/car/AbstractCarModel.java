package com.yida.design.builder.demo.car;

import java.util.ArrayList;
import java.util.List;

/**
 *********************
 * 汽车模型
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:26:44
 ***********************
 */
public abstract class AbstractCarModel {
	// 基本方法执行顺序
	private List<String> sequence = new ArrayList<String>();

	// 起步
	protected abstract void start();

	// 停止
	protected abstract void stop();

	// 鸣笛
	protected abstract void alarm();

	// 发动机声音
	protected abstract void engineBoom();

	// 执行
	final public void run() {
		for (int i = 0; i < this.sequence.size(); i++) {
			String actionName = this.sequence.get(i);
			if ("start".equalsIgnoreCase(actionName)) {
				this.start();
			} else if ("stop".equalsIgnoreCase(actionName)) {
				this.stop();
			} else if ("alarm".equalsIgnoreCase(actionName)) {
				this.alarm();
			} else if ("engineBoom".equalsIgnoreCase(actionName)) {
				this.engineBoom();
			}
		}
	}

	// 设置执行顺序
	final public void setSequence(List<String> sequence) {
		this.sequence = sequence;
	}
}
