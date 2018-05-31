package com.yida.design.adapter.generator.main;

import com.yida.design.adapter.generator.Target;
import com.yida.design.adapter.generator.adapter.Adapter;
import com.yida.design.adapter.generator.impl.ConcreteTarget;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:09:44
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 原有的业务逻辑
		Target target = new ConcreteTarget();
		target.request();
		// 现在增加了适配器角色后的业务逻辑
		Target target2 = new Adapter();
		target2.request();
	}
}
