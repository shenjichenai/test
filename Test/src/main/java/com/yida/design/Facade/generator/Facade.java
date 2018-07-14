package com.yida.design.Facade.generator;

import com.yida.design.Facade.generator.subsystem.ClassA;
import com.yida.design.Facade.generator.subsystem.ClassB;
import com.yida.design.Facade.generator.subsystem.ClassC;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月14日 下午5:41:57
 ***********************
 */
public class Facade {
	// 被委托的对象
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	private ClassC c = new ClassC();

	// 提供给外部访问的方法
	public void methodA() {
		this.a.doSomethingA();
	}

	public void methodB() {
		this.b.doSomethingB();
	}

	public void methodC() {
		this.c.doSomethingC();
	}
}
