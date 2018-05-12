package com.yida.design.command.demo;

import com.yida.design.command.demo.command.Command;
import com.yida.design.command.demo.command.DeletePageCommand;

/**
 *********************
 * 客户端
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:38:00
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		Invoker yk = new Invoker();
		// 增加需求的命令
		// Command command = new AddRequirementCommand();
		// 删除页面的命令
		Command command = new DeletePageCommand();
		yk.setCommand(command);
		yk.action();
	}
}
