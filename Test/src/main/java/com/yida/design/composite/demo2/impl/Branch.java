package com.yida.design.composite.demo2.impl;

import java.util.ArrayList;
import java.util.List;

import com.yida.design.composite.demo2.Corp;

/**
 *********************
 * 枝节点
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午2:40:38
 ***********************
 */
public class Branch extends Corp {
	// 领导下边有哪些下级领导和小兵
	List<Corp> subordinateList = new ArrayList<Corp>();

	public Branch(String name, String position, int salary) {
		super(name, position, salary);
	};

	// 增加一个下属，可能是小头目，也可能是个小兵
	public void addSubordinate(Corp corp) {
		this.subordinateList.add(corp);
	}

	// 我有哪些下属
	public List<Corp> getSubordinate() {
		return this.subordinateList;
	}
}
