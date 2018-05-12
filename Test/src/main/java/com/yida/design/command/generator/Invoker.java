package com.yida.design.command.generator;

/**
 *********************
 * 调用者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午11:01:05
 ***********************
 */
public class Invoker {
	private Command command;

	// 接收命令
	public void setCommand(Command command) {
		this.command = command;
	}

	// 执行命令
	public void action() {
		this.command.execute();
	}
}
