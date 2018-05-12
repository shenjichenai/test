package com.yida.design.command.generator;

/**
 *********************
 * 抽象命令类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:56:18
 ***********************
 */
public abstract class Command {
	// 每个命令类必须有一个执行命令的方法
	public abstract void execute();
}
