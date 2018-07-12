package com.yida.design.composite.extension.impl;

import java.util.List;

import com.yida.design.composite.extension.Component;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午3:40:25
 ***********************
 */
public class Leaf extends Component {

	@Override
	public void add(Component component) {
		// 空实现,直接抛弃一个"不支持请求"异常
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(Component component) {
		// 空实现
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Component> getChildren() {
		// 空实现
		throw new UnsupportedOperationException();
	}

}
