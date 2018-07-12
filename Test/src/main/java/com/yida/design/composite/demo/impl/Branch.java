package com.yida.design.composite.demo.impl;

import java.util.ArrayList;
import java.util.List;

import com.yida.design.composite.demo.IBranch;
import com.yida.design.composite.demo.ICorp;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月13日 下午2:38:30
 ***********************
 */
public class Branch implements IBranch {

	// 领导人名称
	private String name = "";
	// 领导人职位
	private String position = "";
	// 领导人薪水
	private int salary = 0;

	// 下级
	List<ICorp> subordinateList = new ArrayList<ICorp>();

	// 初始化领导人
	public Branch(String name, String position, int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	@Override
	public String getInfo() {
		return this.toString();
	}

	@Override
	public void addSubordinate(ICorp corp) {
		this.subordinateList.add(corp);
	}

	@Override
	public List<ICorp> getSubordinate() {
		return this.subordinateList;
	}

	@Override
	public String toString() {
		return "Branch [name=" + name + ", position=" + position + ", salary=" + salary + ", subordinateList="
				+ subordinateList + "]";
	}

}
