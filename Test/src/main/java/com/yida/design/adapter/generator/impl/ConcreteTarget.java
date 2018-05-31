package com.yida.design.adapter.generator.impl;

import com.yida.design.adapter.generator.Target;

/**
 *********************
 * 目标角色实现类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:05:11
 ***********************
 */
public class ConcreteTarget implements Target {

	@Override
	public void request() {
		System.out.println("if you need any help,pls call me!");
	}

}
