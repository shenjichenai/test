package com.yida.design.command.demo.command;

/**
 *********************
 * 删除页面的命令
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:32:20
 ***********************
 */
public class DeletePageCommand extends Command {

	@Override
	public void execute() {
		// 找到美工组
		super.pageGroup.find();
		// 删除页面
		super.pageGroup.delete();
		// 给出计划
		super.pageGroup.plan();
	}

}
