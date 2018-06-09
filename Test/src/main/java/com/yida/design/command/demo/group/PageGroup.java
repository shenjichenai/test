package com.yida.design.command.demo.group;

/**
 *********************
 * 美工组
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:02:12
 ***********************
 */
public class PageGroup extends AbstractGroup {

	@Override
	public void find() {
		System.out.println("客户找到美工组");
	}

	@Override
	public void add() {
		System.out.println("客户要求美工组添加页面");
	}

	@Override
	public void delete() {
		System.out.println("客户要求美工组删除页面");
	}

	@Override
	public void change() {
		System.out.println("客户要求美工组更改页面");
	}

	@Override
	public void plan() {
		System.out.println("客户要求美工组变更计划");
	}

}
