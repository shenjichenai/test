package com.yida.design.composite.demo;

import java.util.List;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月13日 下午2:34:32
 ***********************
 */
public interface IBranch extends ICorp {
	// 能够增加小兵（树叶节点）或者是经理（树枝节点）
	void addSubordinate(ICorp crop);

	// 我还要能够获得下属的信息
	List<ICorp> getSubordinate();

	/*
	 * 本来还应该有一个方法delSubordinate(ICorp corp)，删除下属 这个方法我们没有用到就不写进来了
	 */
}
