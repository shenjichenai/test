package com.yida.design.adapter.extension.impl;

import java.util.HashMap;
import java.util.Map;

import com.yida.design.adapter.extension.IOuterUserHomeInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:33:15
 ***********************
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {

	/*
	 * 员工的家庭信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getUserHomeInfo() {
		HashMap homeInfo = new HashMap();
		homeInfo.put("homeTelNumbner", "员工的家庭电话是...");
		homeInfo.put("homeAddress", "员工的家庭地址是...");
		return homeInfo;
	}

}
