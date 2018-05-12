package com.yida.design.strategy.generator;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:44:48
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 声明一个具体的策略
		Strategy strategy = new ConcreteStrategy1();
		// 声明上下文对象
		Context context = new Context(strategy);
		// 执行封装后的方法
		context.doAnythinig();
	}
}
