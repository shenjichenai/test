package com.yida.design.responsibility.generator;

import com.yida.design.responsibility.generator.concrete.ConcreteHandler1;
import com.yida.design.responsibility.generator.concrete.ConcreteHandler2;
import com.yida.design.responsibility.generator.concrete.ConcreteHandler3;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:43:08
 ***********************
 */
public class Client {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 声明所有的处理节点
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		Handler handler3 = new ConcreteHandler3();
		// 设置链中的阶段顺序1-->2-->3
		handler1.setNext(handler2);
		handler2.setNext(handler3);
		// 提交请求，返回结果
		Response response = handler1.handlerMessage(new Request());
	}
}
