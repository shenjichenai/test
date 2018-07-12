package com.yida.design.composite.generator.main;

import com.yida.design.composite.generator.Component;
import com.yida.design.composite.generator.impl.Composite;
import com.yida.design.composite.generator.impl.Leaf;

/**
 *********************
 * 场景类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午3:13:44
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 创建一个根节点
		Composite root = new Composite();
		root.doSomething();
		// 创建一个树枝构件
		Composite branch = new Composite();
		// 创建一个叶子节点
		Leaf leaf = new Leaf();
		// 建立整体
		root.add(branch);
		branch.add(leaf);
	}

	// 通过递归遍历树
	public static void display(Composite root) {
		for (Component c : root.getChildren()) {
			if (c instanceof Leaf) { // 叶子节点
				c.doSomething();
			} else { // 树枝节点
				display((Composite) c);
			}
		}
	}
}
