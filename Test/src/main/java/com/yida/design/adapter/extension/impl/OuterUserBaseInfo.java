package com.yida.design.adapter.extension.impl;

import java.util.HashMap;
import java.util.Map;

import com.yida.design.adapter.extension.IOuterUserBaseInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:31:03
 ***********************
 */
public class OuterUserBaseInfo implements IOuterUserBaseInfo {

	/*
	 * 用户的基本信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getUserBaseInfo() {
		HashMap baseInfoMap = new HashMap();
		baseInfoMap.put("userName", "这个员工叫混世魔王...");
		baseInfoMap.put("mobileNumber", "这个员工电话是...");
		return baseInfoMap;
	}

}
