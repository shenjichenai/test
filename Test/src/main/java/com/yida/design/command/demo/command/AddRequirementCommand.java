package com.yida.design.command.demo.command;

/**
 *********************
 * 增加需求的命令
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:28:58
 ***********************
 */
public class AddRequirementCommand extends AbstractCommand {

	@Override
	public void execute() {
		// 找到需求
		super.requirementGroup.find();
		// 增加需求
		super.requirementGroup.add();
		// 给出计划
		super.requirementGroup.plan();
	}

}
