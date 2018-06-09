package com.yida.design.command.generator;

/**
 *********************
 * 接收者角色
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:51:04
 ***********************
 */
public abstract class AbstractReceiver {
	// 定义每个接收者都必须完成的业务
	public abstract void doSomething();
}
