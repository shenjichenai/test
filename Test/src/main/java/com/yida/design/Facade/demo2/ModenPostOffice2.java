package com.yida.design.Facade.demo2;

import com.yida.design.Facade.demo.ILetterProcess;
import com.yida.design.Facade.demo.impl.LetterProcessImpl;
import com.yida.design.Facade.demo2.check.Police;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月14日 下午5:17:07
 ***********************
 */
public class ModenPostOffice2 {

	private ILetterProcess letterProcess = new LetterProcessImpl();

	private Police letterPolice = new Police();

	// 写信，封装，投递，一体化
	public void sendLetter(String context, String address) {
		// 帮你写信
		letterProcess.writeContext(context);
		// 写好信封
		letterProcess.fillEnvelope(address);
		// 警察要检查信件了
		letterPolice.checkLetter(letterProcess);
		// 把信放到信封中
		letterProcess.letterInotoEnvelope();
		// 邮递信件
		letterProcess.sendLetter();
	}
}
