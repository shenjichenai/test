package com.yida.design.composite.extension2.impl;

import java.util.ArrayList;
import java.util.List;

import com.yida.design.composite.extension2.Corp;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午3:55:26
 ***********************
 */
public class Branch extends Corp {

	// 领导下边有哪些下级领导和小兵
	List<Corp> subordinateList = new ArrayList<Corp>();

	public Branch(String _name, String _position, int _salary) {
		super(_name, _position, _salary);
	}

	// 增加一个下属，可能是小头目，也可能是个小兵
	public void addSubordinate(Corp corp) {
		corp.setParent(this); // 设置父节点
		this.subordinateList.add(corp);
	}

	// 我有哪些下属
	public List<Corp> getSubordinate() {
		return this.subordinateList;
	}
}
