package com.yida.design.factory.main;

import com.yida.design.factory.Human;
import com.yida.design.factory.extend.BlackHumanFactory;
import com.yida.design.factory.extend.WhiteHumanFactory;
import com.yida.design.factory.extend.YellowHumanFactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:14:04
 ***********************
 */
public class NvWa2 {
	public static void main(String[] args) {
		Human blackHuman = (new BlackHumanFactory()).createHuman();
		blackHuman.getColor();
		blackHuman.talk();

		Human whiteHuman = (new WhiteHumanFactory()).createHuman();
		whiteHuman.getColor();
		whiteHuman.talk();

		Human yellowHuman = (new YellowHumanFactory()).createHuman();
		yellowHuman.getColor();
		yellowHuman.talk();
	}
}
