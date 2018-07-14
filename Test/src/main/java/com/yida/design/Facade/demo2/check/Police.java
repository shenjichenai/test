package com.yida.design.Facade.demo2.check;

import com.yida.design.Facade.demo.ILetterProcess;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月14日 下午5:27:09
 ***********************
 */
public class Police {
	// 检查信件，检查完毕后警察在信封上盖个戳：此信无病毒
	public void checkLetter(ILetterProcess letterProcess) {
		System.out.println(letterProcess + " 信件已经检查过了...");
	}
}
