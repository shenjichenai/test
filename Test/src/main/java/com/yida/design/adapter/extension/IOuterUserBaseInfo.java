package com.yida.design.adapter.extension;

import java.util.Map;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午5:27:54
 ***********************
 */
public interface IOuterUserBaseInfo {
	// 基本信息，比如名称、性别、手机号码等
	@SuppressWarnings("rawtypes")
	public Map getUserBaseInfo();
}
