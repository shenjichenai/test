package com.yida.design.command.demo.group;

/**
 *********************
 * 逻辑实现组
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:09:13
 ***********************
 */
public class CodeGroup extends Group {

	@Override
	public void find() {
		System.out.println("客户找到逻辑实现组");
	}

	@Override
	public void add() {
		System.out.println("客户要求逻辑实现组添加功能");
	}

	@Override
	public void delete() {
		System.out.println("客户要求逻辑实现组删除功能");
	}

	@Override
	public void change() {
		System.out.println("客户要求逻辑实现组更改功能");
	}

	@Override
	public void plan() {
		System.out.println("客户要求逻辑实现组变更计划");
	}

}
