package com.yida.design.agency.impl;

import com.yida.design.agency.Subject;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月19日 下午5:56:54
 ***********************
 */
public class Proxy implements Subject {
	// 要代理哪个实现类
	private Subject subject = null;

	// 默认被代理者
	public Proxy() {
		this.subject = new Proxy();
	}

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	// 通过构造函数传递代理者
	public Proxy(Object... objects) {
	}

	@Override
	public void request() {
		this.before();
		this.subject.request();
		this.after();
	}

	// 预处理
	private void before() {
		// do something
	}

	// 善后处理
	private void after() {
		// do something
	}
}
