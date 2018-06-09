package com.yida.design.command.demo;

import com.yida.design.command.demo.command.AbstractCommand;

/**
 *********************
 * 负责人
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:35:10
 ***********************
 */
public class Invoker {
	// 什么命令
	private AbstractCommand command;

	// 设置命令
	public void setCommand(AbstractCommand command) {
		this.command = command;
	}

	// 执行命令
	public void action() {
		this.command.execute();
	}
}
