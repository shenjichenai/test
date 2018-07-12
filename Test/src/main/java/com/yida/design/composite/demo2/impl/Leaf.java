package com.yida.design.composite.demo2.impl;

import com.yida.design.composite.demo2.Corp;

/**
 *********************
 * 叶节点
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午2:38:40
 ***********************
 */
public class Leaf extends Corp {
	// 就写一个构造函数，这个是必需的
	public Leaf(String name, String position, int salary) {
		super(name, position, salary);
	};
}
