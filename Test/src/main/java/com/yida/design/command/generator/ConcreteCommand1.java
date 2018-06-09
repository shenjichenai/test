package com.yida.design.command.generator;

/**
 *********************
 * 具体的命令类（可以有N个）
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:58:33
 ***********************
 */
public class ConcreteCommand1 extends AbstractCommand {

	private AbstractReceiver receiver;

	public ConcreteCommand1(AbstractReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.doSomething();
	}

}
