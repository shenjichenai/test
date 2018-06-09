package com.yida.design.command.demo.group;

/**
 *********************
 * 需求组
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午9:58:21
 ***********************
 */
public class RequirementGroup extends AbstractGroup {

	@Override
	public void find() {
		System.out.println("客户找到需求组");
	}

	@Override
	public void add() {
		System.out.println("客户要求需求组添加需求");
	}

	@Override
	public void delete() {
		System.out.println("客户要求需求组删除需求");
	}

	@Override
	public void change() {
		System.out.println("客户要求需求组更改需求");
	}

	@Override
	public void plan() {
		System.out.println("客户要求需求组变更计划");
	}

}
