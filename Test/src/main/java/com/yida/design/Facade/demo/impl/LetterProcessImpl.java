package com.yida.design.Facade.demo.impl;

import com.yida.design.Facade.demo.ILetterProcess;

/**
 *********************
 * 写信过程的实现
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月14日 下午5:15:16
 ***********************
 */
public class LetterProcessImpl implements ILetterProcess {

	@Override
	public void writeContext(String context) {
		System.out.println("填写信的内容..." + context);
	}

	@Override
	public void fillEnvelope(String address) {
		System.out.println("填写收件人地址及姓名..." + address);
	}

	@Override
	public void letterInotoEnvelope() {
		System.out.println("把信放到信封中...");
	}

	@Override
	public void sendLetter() {
		System.out.println("邮递信件...");
	}

}
