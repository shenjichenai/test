package com.yida.design.composite.extension.main;

import com.yida.design.composite.extension.Component;
import com.yida.design.composite.extension.impl.Leaf;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午3:42:56
 ***********************
 */
public class Client {
	// 通过递归遍历树
	public static void display(Component root) {
		for (Component c : root.getChildren()) {
			if (c instanceof Leaf) { // 叶子节点
				c.doSomething();
			} else { // 树枝节点
				display(c);
			}
		}
	}
}
