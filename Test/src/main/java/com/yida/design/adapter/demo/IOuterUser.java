package com.yida.design.adapter.demo;

import java.util.Map;

/**
 *********************
 * 劳务公司信息表
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午4:33:02
 ***********************
 */
public interface IOuterUser {
	// 基本信息，比如名称、性别、手机号码等
	@SuppressWarnings("rawtypes")
	public Map getUserBaseInfo();

	// 工作区域信息
	@SuppressWarnings("rawtypes")
	public Map getUserOfficeInfo();

	// 用户的家庭信息
	@SuppressWarnings("rawtypes")
	public Map getUserHomeInfo();
}
