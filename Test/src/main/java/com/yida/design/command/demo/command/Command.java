package com.yida.design.command.demo.command;

import com.yida.design.command.demo.group.CodeGroup;
import com.yida.design.command.demo.group.PageGroup;
import com.yida.design.command.demo.group.RequirementGroup;

/**
 *********************
 * 抽象命令类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 上午10:23:41
 ***********************
 */
public abstract class Command {
	// 定义好3个组
	protected RequirementGroup requirementGroup = new RequirementGroup();
	protected CodeGroup codeGroup = new CodeGroup();
	protected PageGroup pageGroup = new PageGroup();

	// 一个方法，你要我做什么事
	public abstract void execute();
}
