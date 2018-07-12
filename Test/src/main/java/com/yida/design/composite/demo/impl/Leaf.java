package com.yida.design.composite.demo.impl;

import com.yida.design.composite.demo.ILeaf;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月13日 下午2:20:32
 ***********************
 */
public class Leaf implements ILeaf {

	// 小兵名字
	private String name = "";
	// 小兵职位
	private String position = "";
	// 小兵薪水
	private int salary = 0;

	// 初始化小兵信息
	public Leaf(String name, String position, int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	/**
	 * 获取小兵信息
	 */
	@Override
	public String getInfo() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Leaf [name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}

}
