package com.yida.design.composite.demo2;

/**
 *********************
 * 抽象公司职员类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午2:33:57
 ***********************
 */
public abstract class Corp {
	// 公司每个人都有名称
	private String name = "";
	// 公司每个人都职位
	private String position = "";
	// 公司每个人都有薪水
	private int salary = 0;

	public Corp() {
		super();
	}

	public Corp(String name, String position, int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public String getInfo() {
		return toString();
	}

	@Override
	public String toString() {
		return "Corp [名称=" + name + ", 职位=" + position + ", 薪水=" + salary + "]";
	}

}
