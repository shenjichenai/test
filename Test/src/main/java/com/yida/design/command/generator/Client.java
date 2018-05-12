package com.yida.design.command.generator;

/**
 *********************
 * 客户端
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午11:03:40
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 声明调用者
		Invoker invoker = new Invoker();
		// 定义接收者
		ConcreteReciver1 receiver = new ConcreteReciver1();
		// 定义接收者命令
		Command command = new ConcreteCommand1(receiver);
		// 把命令交给调用者去执行
		invoker.setCommand(command);
		invoker.action();
	}
}
