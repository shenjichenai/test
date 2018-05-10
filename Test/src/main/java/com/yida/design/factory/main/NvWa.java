package com.yida.design.factory.main;

import com.yida.design.factory.AbstractHumanFactory;
import com.yida.design.factory.extend.HumanFactory;
import com.yida.design.factory.extend.StaticHumanFactory;
import com.yida.design.factory.impl.BlackHuman;
import com.yida.design.factory.impl.WhiteHuman;
import com.yida.design.factory.impl.YellowHuman;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:14:04
 ***********************
 */
public class NvWa {
	public static void main(String[] args) {
		AbstractHumanFactory yinYangLu = new HumanFactory();

		WhiteHuman createHuman = StaticHumanFactory.createHuman(WhiteHuman.class);
		createHuman.talk();
		System.err.println("静态");

		// 第一次造人火候不足，造了白人
		WhiteHuman whiteHuman = yinYangLu.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();

		BlackHuman blackHuman = yinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();

		YellowHuman yellowHuman = yinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
	}
}
