package com.yida.design.adapter.extension.impl;

import java.util.HashMap;
import java.util.Map;

import com.yida.design.adapter.extension.IOuterUserOfficeInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:34:32
 ***********************
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

	/*
	 * 员工的工作信息，比如，职位等
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getUserOfficeInfo() {
		HashMap officeInfo = new HashMap();
		officeInfo.put("jobPosition", "这个人的职位是BOSS...");
		officeInfo.put("officeTelNumber", "员工的办公电话是...");
		return officeInfo;
	}

}
